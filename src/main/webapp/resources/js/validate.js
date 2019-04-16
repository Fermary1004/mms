$(document).ready(function() {
	$(function() {
    $("#signup").validate({
      rules: {
      	member_email: {
          required: true,
          minlength: 2,
          email: true
        },
        member_pw: {
          required: true,
          minlength: 6,
          regex: /^(?=\w{6,20}$)\w*(\d[A-z]|[A-z]\d)\w*$/
        },
        member_nick: {
          required: true,
          minlength: 4
        },
        member_name: {
          required: true,
          minlength: 2
        },
        inputbirth: {
          required: true
        }
      },
      messages: {
        member_email: {
          required: "필수로입력하세요",
          minlength: "최소 {0}글자이상이어야 합니다",
          email: "메일규칙에 어긋납니다"
        },
        member_pw: {
          required: "필수로입력하세요",
          minlength: "최소 {0}글자이상이어야 합니다",
          regex: "영문자, 숫자로 이루어져있으며 최소 하나이상 포함"
        },
        member_nick: {
          required: "필수로입력하세요",
          minlength: "최소 {0}글자이상이어야 합니다"
        },
        member_name: {
          required: "필수로입력하세요",
          minlength: "최소 {0}글자이상이어야 합니다"
        },
        inputbirth: {
          required: "필수로입력하세요"
        }
      }
    });
  });
	
	$(function() {
    $("#profile").validate({
      rules: {
      	member_pw: {
          required: false,
          minlength: 6,
          regex: /^(?=\w{6,20}$)\w*(\d[A-z]|[A-z]\d)\w*$/
        },
        member_nick: {
          required: true,
          minlength: 4,
        },
        member_name: {
          required: true,
          minlength: 2,
        },
        inputbirth: {
          required: false,
        }
      },
      messages: {
        member_pw: {
          minlength: "최소 {0}글자이상이어야 합니다",
          regex: "영문자, 숫자로 이루어져있으며 최소 하나이상 포함"
        },
        member_nick: {
          required: "필수로입력하세요",
          minlength: "최소 {0}글자이상이어야 합니다",
        },
        member_name: {
          required: "필수로입력하세요",
          minlength: "최소 {0}글자이상이어야 합니다",
        },
        inputbirth: {
          minlength: "최소 {0}글자이상이어야 합니다",
        }
      }
    });
  });
	
	$("#submit").click(function(){
	var member_email = "";
	member_email = $("#member_email").val();
		$.ajax({
			async:true,
			type:'POST',
			data:member_email,
			url:"/mms/signup/dup",
			dataType:"json",
			contentType:"application/json; charset=UTF-8",
			success : function(data){
				if(data.dup){
					alert('이미 사용중인 아이디입니다');
					return false;
				} else {
					$("#signup").submit();
					return true;
				}
			}
		});
	});

  $.validator.addMethod(
    "regex",
    function(value, element, regexp) {
      var re = new RegExp(regexp);
      return this.optional(element) || re.test(value);
    },
    "Please check your input."
  );
})