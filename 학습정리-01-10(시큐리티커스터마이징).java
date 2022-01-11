1. 스프링 시큐리티를 커스텀 마이징 하여 아래의 요소가 나오도록 하시오.
-프로젝트를 새롭게 생성할것 
-todo list 를 작성할것

<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p> 

1. pom.xml 내용 추가
2. web.xml 내용 추가 + 시큐리티 부분 빼기
3. servlet-context.xml, root-context.xml, security-context.xml 추가
4. src/main/resources 안에 log4j.xml, log4jdbc.log4j2.properties 추가
5. EmpVO.java 작성
package edu.kosmo.ex.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Log4j
public class EmpVO {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Timestamp hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	private List<AuthVO> authList;
}

6. AuthVO.java 작성
package edu.kosmo.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AuthVO {
	private String username;
	private String authority;	
}

7. EmpMapper.java 작성
package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.ex.vo.AuthVO;
import edu.kosmo.ex.vo.EmpVO;

@Mapper
public interface EmpMapper {
	
	@Select("select * from emp where ename = #{ename}")
	public EmpVO readUser(String name);
	
	@Select("select ename,case when job='MANAGER' then 'ROLE_ADMIN' else  'ROLE_USER' end authority from emp where ename = #{ename}")
	public List<AuthVO> readAuthority(String name);
	
	@Insert("insert into emp(ename,empno) values(#{ename},#{empno})")
	public int insertEmp(EmpVO empVO);
	
}

8. CustomNoOpPasswordEncoder.java 작성
package edu.kosmo.ex.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

/*암호화 안 시키는 거*/
@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{
	
	public String encode(CharSequence rawPassword) {
		log.warn("before encode : " + rawPassword);
		
		return rawPassword.toString();
	}
	
	
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		log.warn("matches : " + rawPassword + ":" + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
	}
}

9. CustomUserDetailsService.java 작성
package edu.kosmo.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.CustomUser;
import edu.kosmo.ex.vo.EmpVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/*
 * username을 가지고 사용자 정보를 조회하고 session에 저장될 사용자 주체 정보인 
 * UserDetails를 반환하는 Interface다.
 */

@Log4j
@Service
public class CustomUserDetailsService implements UserDetailsService  {
	
	@Setter(onMethod_ = @Autowired)
	private EmpMapper empMapper;

	/*
	loadUserByUsername()에서 하는 일
	- username을 가지고 사용자 정보를 조회
	- 사용자의 Role과 권한(Privilege)을 조회하여, SimpleGrantedAuthority 목록을 authorities에 세팅한다.
	- Authentication 내부 principal 객체에 UserDetails 객체가 저장된다.
	- Authentication 내부 authorities 객체에 사용자의 Role과 권한(Privilege) 정보가 저장된다.
	- UserDetails에 authorities가 세팅되어 있어야, API별 role이나 권한 체크를 진행할 수 있다.
	*/
	@Override
	public UserDetails loadUserByUsername(String ename) throws UsernameNotFoundException {
		
		log.warn("Load User By Employee number: " + ename);	
		
		EmpVO vo = empMapper.readUser(ename);
		vo.setAuthList(empMapper.readAuthority(ename)); 
		
		
		
		log.warn("queried by EmpVO mapper: " + vo);		
		
		return vo == null ? null : new CustomUser();		
		//return vo == null ? null : new CustomUserDetails(vo);
		
	}	

}

10. CustomUser.java 작성
package edu.kosmo.ex.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser implements UserDetails {

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}

11. home.jsp 작성
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>메이페이지</title>
</head>

<body>

<h1>메인페이지</h1>

<sec:authorize access="isAnonymous()">
   <p><a href="<c:url value="/login" />">로그인</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
	<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p> 
</sec:authorize>

<h3>
    [<a href="<c:url value="/user/userForm" />">회원가입</a>]
    [<a href="<c:url value="/user/userHome" />">유저 홈</a>]
    [<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
</h3>
</body>
</html>
