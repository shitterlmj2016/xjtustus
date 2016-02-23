$(function() { 
     
	   $(".input").blur(function() {
		var inputName = $(this).attr("name");
		invokeValidateFunction(inputName);
	    });
	    
	     $(".input").focus(function() {
		 var inputName = $(this).attr("name");
         var str=inputName.replace(/loginUser./,"");
		 $("#" + str + "Error").css("display", "none");
	     });
	    
	     /*
		 	 * 5. ���<label>�����ݣ���ô��ʾ��û�в���ʾ��
		 */
	 	$(".labelError").each(function() {
	 		if($(this).text()) {
	 			$(this).css("display", "");
	 		} else {
	 			$(this).css("display", "none");
	 		}
	 	});
	    
	 } ) ; 

    function invokeValidateFunction(inputName) {
	 var str=inputName.replace(/loginUser./,"");
	 var functionName = "validate" + str;
	 return eval(functionName + "()");	
    }


    function validateusername() {
     var bool=true;
   	 var value = $("#username").val();
   	 if(!value) {
   	    $("#usernameError").css("display", "");
   		$("#usernameError").text("�û�������Ϊ�գ�");
   		bool=false;
   	 } else if(value.length < 3 || value.length > 20) {
   		$("#usernameError").css("display", "");
   		$("#usernameError").text("�û���������3 ~ 20֮�䣡");
   		bool=false;
   	}
   	  return bool;
    } 
    
    
    /**
     * 
       У������
     */
    function validatepassword() {
	var bool = true;
	$("#passwordError").css("display", "none");
	var value = $("#password").val();
    if(!value) {
		$("#passwordError").css("display", "");
		$("#passwordError").text("���벻��Ϊ�գ�");
	bool = false;
	} else if(value.length < 3 || value.length > 20) {
		$("#passwordError").css("display", "");
		$("#passwordError").text("���볤����3 ~ 20֮�䣡");
		bool = false;
	}
	return bool;
    }
    
    /**
     * У����֤��
     */
    function validateimageValue() {
    	var bool = true;
    	$("#imageValueError").css("display", "none");
    	var value = $("#imageValue").val();
    	if(!value) {//�ǿ�У��
    		$("#imageValueError").css("display", "");
    		$("#imageValueError").text("��֤�벻��Ϊ�գ�");
    		bool = false;
    	} else if(value.length != 4) {//���Ȳ�Ϊ4���Ǵ����
    		$("#imageValueError").css("display", "");
    		$("#imageValueError").text("�������֤�룡");
    		bool = false;
    	} else {//��֤���Ƿ���ȷ
    		$.ajax({
    			cache: false,
    			async: false,
    			type: "POST",
    			dataType: "json",
    			data: {imageValue: value},
    			url: "user!checkImageValue.action",
    			success: function(flag) {
    				if(!flag) {
    					$("#imageValueError").css("display", "");
    					$("#imageValueError").text("��֤�����");
    					bool = false;									}
    			}
    		});
    	}
    	return bool;
    }
       
       function check(){
    		var bool = true;
    		$(".input").each(function() {
    			var inputName = $(this).attr("name");
    			if(!invokeValidateFunction(inputName)) {
    				bool = false;
    			}
    		})
    		return bool;
       }