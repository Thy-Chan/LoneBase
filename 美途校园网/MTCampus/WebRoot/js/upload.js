$(document).ready(function() {
var srctouxiang=null;
	$("#uploadBtn").click(function() {
		ajaxFileUpload();
	});

});
function ajaxFileUpload() {
	var elementIds = [ "file" ]; //flagΪid��name������
	$.ajaxFileUpload( {
		url : 'upload_exec',
		type : 'post',
		secureuri : false, //һ������Ϊfalse
		fileElementId : 'file', // �ϴ��ļ���id��name������
		dataType : 'text', //����ֵ���ͣ�һ������Ϊjson��application/json
		elementIds : elementIds, //���ݲ�����������
		success : function(data, status) {
		$data = $(data);
		
		$("#headimg").attr("src","upload/"+data);
		$("input[name='#request.student.UTouxiang']").val(data);
		$.ajax({
			url:'stu_update',
			data:{"touxiang":data},
			success: function (obj){
				
			}
		});
		
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
	//return false;
}