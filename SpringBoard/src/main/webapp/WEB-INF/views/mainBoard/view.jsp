<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $(document).ready(function(){
        /* $("#btnSave").click(function(){
            //var title = document.form1.title.value; ==> name속성으로 처리할 경우
            //var content = document.form1.content.value;
            //var writer = document.form1.writer.value;
            var seq = $("#seq").val();
            var title = $("#title").val();
            var text = $("#text").val();
            var writer = $("#writer").val();
            var password = $("#password").val();
            
            if(title == ""){
                alert("제목을 입력하세요");
                document.form1.title.focus();
                return;
            }
            
            if(text == ""){
                alert("내용을 입력하세요");
                document.form1.content.focus();
                return;
            }
            
            if(writer == ""){
                alert("이름을 입력하세요");
                document.form1.writer.focus();
                return;
            }
            
            if(password == ""){
                alert("비밀번호를 입력하세요");
                document.form1.writer.focus();
                return;
            }
            
            // 폼에 입력한 데이터를 서버로 전송
            $.ajax({
            	url : "/myBoard/updateBoard.do",
            	data : {
            		seq : seq,
                	title : title,
                	text : text,
                	writer : writer,
                	password : password,
            	},
            	
	            success : function(data){
	            	location.href = "/myBoard/mainBoardList.do";            		
	            }, 
	            fail : function(){
	            	alter("게시글 수정을 실패하였습니다.");
	            }
            });
			
        }); */
        
        $('form').on('submit', function(e) {
        	console.log(e);
        	
        	var seq = $("#seq").val();
            var title = $("#title").val();
            var text = $("#text").val();
            var writer = $("#writer").val();
            var password = $("#password").val();
            
            if(title == ""){
                alert("제목을 입력하세요");
                document.form1.title.focus();
                return false;
            }
            
            if(text == ""){
                alert("내용을 입력하세요");
                document.form1.content.focus();
                return false;
            }
            
            if(writer == ""){
                alert("이름을 입력하세요");
                document.form1.writer.focus();
                return false;
            }
            
            if(password == ""){
                alert("비밀번호를 입력하세요");
                document.form1.writer.focus();
                return false;
            }
        });
        
        $("#reset").on('click', function(){
        	location.href = "/myBoard/mainBoardList.do";
        });
        
    });
</script>

</head>
<h2>게시글 수정</h2>
<form class="form1" name="form1" action="/myBoard/updateBoard.do">
	<table>
	<tr>
		<td>
	       	 제목
        </td>
        <td>
        <input name="title" id="title" size="80" value="${getWrite.title}">
        <input type="hidden" id="seq" value="${getWrite.seq}">
        </td>
    </tr>
	<tr>
		<td>
        	내용
        </td>
        <td>
        <textarea name="text" id="text" rows="4" cols="80" >${getWrite.text}</textarea>
        </td>
    </tr>
    <tr>
    	<td>
        	이름
        </td>
    	<td>
        <input name="writer" id="writer" value="${getWrite.writer}">
        </td>
    </tr>
    <tr>
    	<td>
        	비밀번호
        </td>
        <td>
        <input type="password" name="password" id="password" maxlength="4" value="${getWrite.password}">
        </td>
    </tr>
    </table>
        <button type="submit" id="btnSave">수정</button>
        <button type="button" id="reset">취소</button>
</form>
</body>
</html>