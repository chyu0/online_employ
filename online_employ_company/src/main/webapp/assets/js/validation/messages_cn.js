jQuery.extend(jQuery.validator.messages, { 
required: "必选字段", 
remote: "请修正该字段", 
email: "邮箱格式错误", 
url: "域名不合法", 
date: "日期格式不合法", 
dateISO: "请输入合法的日期 (ISO).", 
number: "请输入合法的数字", 
digits: "只能输入整数", 
creditcard: "信用卡号不合法", 
equalTo: "前后输入的值不相等", 
accept: "请输入拥有合法后缀名的字符串",
maxlength: jQuery.validator.format("必须输入长度在{0}以内的字符串"), 
minlength: jQuery.validator.format("必须输入长度在{0}以上的字符串"), 
rangelength: jQuery.validator.format("必须输入长度介于{0}和 {1}之间的字符串"), 
range: jQuery.validator.format("必须输入 {0} 和 {1}之间的值"), 
max: jQuery.validator.format("必须输入一个最大为 {0}的值"), 
min: jQuery.validator.format("必须输入一个最小为 {0}的值") 
}); 