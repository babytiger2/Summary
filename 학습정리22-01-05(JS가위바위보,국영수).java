1. 가위 바위보 게임을 아래의 고객 요구 사항에 따라 짜시오.

- js, jquery 문법으로 작성 할것(JSP 문법 필요 없음)
- 최대한 생성자 객체를 만들어서 할것.
- 우선 기능 위주로 하고, UI 는 크게 신경 안쓰셔도 됩니다. (우선 이미지 정도만 나오게 할것) 
- 기존에 짠 UI 소스 그대로 사용 해도됨

 <!DOCTYPE html>
<html lang="en">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>rock paper sis</title>
    <style>
      img{
        width: 300px;
        height: 300px;
      }
    </style>
      <script>
        
          $(document).ready(function(){

            $("#sis").click(function(){
              console.log("가위");
              game(1);
            });
            $("#rock").click(function(){
              console.log("바위");
              game(2);
            });
            $("#paper").click(function(){
              console.log("보");
              game(3);
            });


          function game(user){
            var com = Math.floor(Math.random() * 3+1);
            console.log(" user : " + user + " com : " + com);
            // console.log("가위 = 1");
            // console.log("바위 = 2");
            // console.log("보 = 3");
            fight(user,com);
          }

          function fight(user, com){
            var win = 0;
            var lose = 0;//1;
            var draw = 0;//.2;
            
            console.log("----나:" + user + "---컴:" + com);
            if(com == user){
              console.log("Draw");
              $("#wrap").append("<h2>Draw</h2>")
              draw = 1;//2;
            }else if(com == 1 && user == 2){
              console.log("You win");
              $("#wrap").append("<h2>You win</h2>")
              win = 1;//0;
            }else if(com == 1 && user == 3){
              console.log("You lose");
              $("#wrap").append("<h2>You lose</h2>")
              lose = 1;
            }else if(com == 2 && user == 1){
              console.log("You lose");
              $("#wrap").append("<h2>You lose</h2>")
              lose = 1;
            }else if(com == 2 && user == 3){
              console.log("You win");
              $("#wrap").append("<h2>You win</h2>")
              win = 1;//0;
            }else if(com == 3 && user == 1){
              console.log("You win");
              $("#wrap").append("<h2>You win</h2>")
              win = 1;//0;
            }else if(com == 3 && user == 2){
              console.log("You lose");
              $("#wrap").append("<h2>You lose</h2>")
              lose = 1;
            };

            console.log("----:" + win + "---:" + lose + "===" + draw);
            print(win,lose,draw);

          };


          function print(win,lose,draw) {
            $("#wrap").empty();
            /*
            if(win == 0)
                $("#wrap").append("<h2>당신이 이겼습니다.</h2>")
            else if(lose == 1)
                $("#wrap").append("<h2>당신이 졌습니다.</h2>")
            else if(draw == 2)
                $("#wrap").append("<h2>비겼습니다.</h2>")
                */
              if(win == 1)//0)
                  $("#wrap").append("<h2>당신이 이겼습니다.</h2>")
              if(lose == 1)
                  $("#wrap").append("<h2>당신이 졌습니다.</h2>")
              if(draw == 1)//2)
                 $("#wrap").append("<h2>비겼습니다.</h2>")               
          }
            $("#wrap").append(print());
          });


      </script>

   </head>
   
   <body>
      <img id="imgRSP" src="img/rsp.png"><br>

        <input id="sis" type="button" value="가위">
        <input id="rock" type="button" value="바위">
        <input id="paper" type="button" value="보">

      <div id="wrap">
      </div>

   </body>

</html>
=========================================
내일 아래 한번더 돌리도록 하겠습니다.

1. jS - 국영수를 입력하는 3개의 input 박스를 생성후 , 

-국영수를 입력하는 3개의 input 박스를 생성
-총점 과 리셋 버튼을 생성
-총점 버튼을 누루면 총점과 평균이 나타남

<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    
    <title>Document</title>
    <script>
        $(document).ready( function(){

            $("#avg").click( () => {

                let kor = Number($("#kor").val());
                let eng = Number($("#eng").val());
                let math = Number($("#math").val());
                let total = kor + eng + math;
                let avg = total/3.00;

                let wrapObj = $("#wrap");
                let avgObj = $("#avg");

                console.log(kor);
                console.log(eng);
                console.log(math);
                console.log(avg);
                console.log(total);
                
                let divObj = $('<div>  평균은 '+ avg +  ' </div>' + '<div>  총점은 '+ total +  ' </div>');   
                  $("#wrap").empty();
                  $("#wrap").append(divObj);

            });

            $("#reset").click( () =>{

                $("#wrap").empty();
                $("#kor" ).val(0);
                $("#eng").val(0);
                $("#math").val(0);

            });

        });

    </script>
</head>
<body>

    국어 : <input id="kor" type="text" name="kor"><br>
    영어 : <input id="eng" type="text" name="eng"><br>
    수학 : <input id="math" type="text" name="math"><br>
    <input id="avg" type="button" value="평균">
    <input id="reset" type="button" value="리셋">

    <div id="wrap">
        점수들
    </div>

</body>
</html>
