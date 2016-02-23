  $(function() { 
     
	 	$(".labelError1").each(function() {
	 		if($(this).text()) {
	 			$(this).css("display", "");
	 		} else {
	 			$(this).css("display", "none");
	 		}
	 	});
	   $(".input").blur(function() {
		var inputName = $(this).attr("name");
		invokeValidateFunction(inputName);
	    });
	    
	 	
	     $(".input").focus(function() {
		 var inputName = $(this).attr("name");
		 $("#" + inputName + "Error").css("display", "none");
	     });
	    
	    
	    
	 } ) ; 
       
	 function invokeValidateFunction(inputName) {
	 var functionName = "validate" + inputName;
	 return eval(functionName + "()");	
     }
     
	
	/**
     * У��ԭ����
    */
    function validateoldpassword() {
     var bool = true;
	 $("#oldpasswordError").css("display", "none");
	 var value = $("#oldpassword").val();
	 if(!value) {// �ǿ�У��
		$("#oldpasswordError").css("display", "");
		$("#oldpasswordError").text("ԭ���벻��Ϊ�գ�");
	    bool = false;
		}
	 else if(value.length<3||value.length>20) {//��ʽУ��
		$("#oldpasswordError").css("display", "");
		$("#oldpasswordError").text("�������Ϊ3-20λ��");
		bool = false;
	 } else {//ԭ�����Ƿ���ȷ
		$.ajax({
		cache: false,
		async: false,
			type: "POST",
			dataType: "json",
			data: {oldpassword: value},
			url: "user!CheckPassword.action",
			success: function(flag) {
				if(flag) {
					$("#oldpasswordError").css("display", "");
					$("#oldpasswordError").text("ԭ���벻��ȷ��");
					bool = false;					
				}
			}
		  });		
	  }
	  return bool;
}

 	
	/**
     * У��������
    */
    function validatenewpassword() {
     var bool = true;
	 $("#newpasswordError").css("display", "none");
	 var value = $("#newpassword").val();
	 if(!value) {// �ǿ�У��
		$("#newpasswordError").css("display", "");
		$("#newpasswordError").text("�����벻��Ϊ�գ�");
	    bool = false;
		}
	 else if(value.length<3||value.length>20) {//��ʽУ��
		$("#newpasswordError").css("display", "");
		$("#newpasswordError").text("�������Ϊ3-20λ��");
		bool = false;
	 } 
	  return bool;
}

      	
	/**
     * У��ȷ������
    */
    function validaterepassword() {
     var bool = true;
	 $("#repasswordError").css("display", "none");
	 var value = $("#repassword").val();
	 if(!value) {// �ǿ�У��
		$("#repasswordError").css("display", "");
		$("#repasswordError").text("ȷ�����벻��Ϊ�գ�");
	    bool = false;
		}
	 else if(value.length<3||value.length>20) {//��ʽУ��
		$("#repasswordError").css("display", "");
		$("#repasswordError").text("�������Ϊ3-20λ��");
		bool = false;
	 }  else if(value != $("#newpassword").val()) {//���������Ƿ�һ��
	    $("#repasswordError").css("display", "");
		$("#repasswordError").text("�������벻һ�£�");
		bool = false;
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
		});
		return bool;
   } 