1. JS - 가위 바위 보 3개의 버튼을 작성후 해당 버튼을 누르면 이미지가 바뀌게 하시오
<script>
        $(document).ready(function(){

          $('#siss').click(function(){
            $('#imgRSP').attr("src", "img/sis.jpg")
          });

          $('#rock').click(function(){
            $('#imgRSP').attr("src", "img/rock.jpg")
          });

          $('#paper').click(function(){
            $('#imgRSP').attr("src", "img/paper.jpg")
          });

        });
</script>
</head>
   
<body>
	<img id="imgRSP" src="img/rsp.png"><br>
    
	<input id="siss" type="button" value="가위">
	<input id="rock" type="button" value="바위">
	<input id="paper" type="button" value="보">
</body>

2. 스프링 시큐티 설정을 위한 pom.xml 과 web.xml 및 가장 기본적인
security-context.xml 설정은?
버전을 맞춰야 한다. 가장 기본적인 것
- pom.xml : 스프링 시큐리티에 대한 태그가 필수 
- web.xml : springSecurityFilterChain에 대한 태그 필요
- security-context.xml : 
	<!-- 무조건 있어야 되는 아래 4가지 -->
	<beans:bean id="customNoOpPasswordEncoder" class="edu.kosmo.ex.security.CustomNoOpPasswordEncoder"/> 
	<beans:bean id="customUserDetailsService" class="edu.kosmo.ex.security.CustomUserDetailsService"/> 
    
	<!-- BLAKE 7698 -->
	<!--  provider  -->
	<authentication-manager>
	<authentication-provider user-service-ref="customUserDetailsService">
		<password-encoder ref="customNoOpPasswordEncoder"/>
	</authentication-provider>
	</authentication-manager>

3. 인증과 권한에 대하여 설명하시오.
인증과 권한 = 보안 = 로그인이다.
일반인 권한과 어드밋 권한은 다르기 때문에 로그인 시 일반인 권한인지 어드밋 권한인지 걸러주는 게 스프링 시큐리티. 
스프링 시큐리티는 로그인 처리를 위한 솔루션.
