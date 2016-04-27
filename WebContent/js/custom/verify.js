function validate_required(field,alerttxt){
	with (field)
	{
		if (value==null||value==""){
			alert(alerttxt);
			return false
		}else{
			return true
		}
	}
}

function validate_form(thisform)
{
with (thisform)
  {
  if (validate_required(name,"用户名不能为空！")==false){
	  name.focus();
      return false;
      }else if(validate_required(pwd,"密码不能为空！")==false){
	  pwd.focus();
      return false;
      }
  }
}

function validate_form2(thisform)
{
with (thisform)
  {
  if (validate_required(name,"用户名不能为空！")==false){
	  name.focus();
      return false;
      }else if(validate_required(password,"密码不能为空！")==false){
	  password.focus();
      return false;
      }
  }
}