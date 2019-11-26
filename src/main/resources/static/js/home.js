var lkm = 0;
$("#addBtn").click(function(){
	lkm++;
	$("table.table.table-bordered").show();
	var question = $("#questionInput").val();
	var questionType = $("#questionTypeSelect option:selected").text();
	var type = $("#questionTypeSelect option:selected").val();
	$("#questionListTbody").append(
			'<tr id="'+lkm+'Tr">'+
		       '<th scope="row">'+lkm+'</th>'+
		       '<td colspan="3" class="questionTd" data="'+type+'">'+question+'</td>'+
		       '<td>'+questionType+'</td>'+
		       '<td class="text-center"><span class="oi oi-circle-x" title="icon name" aria-hidden="true" data="#'+lkm+'Tr"></span></td>'+
		    '</tr>');
});

$( document ).on("click", "span.oi.oi-circle-x", function(){
	var data = $(this).attr("data");
	$(data).remove();
});

var questionaryId = 0;
$("#thankModal").on("hidden.bs.modal", function(){
	location.href += "questionaries/questionary/"+questionaryId;
});

$("#createBtn").click(function(){
	var requestObj = new Object();
	var questionArr = new Array();
	var name = $("#questionaryName").val();
	$("td.questionTd").each(function(){
		var questionObj = new Object(), questionType = new Object();
		questionObj.question = $(this).text();
		questionType.questionTypeId = parseInt($(this).attr("data"));
		questionObj.questionType = questionType;
		questionArr.push(questionObj);
	});
	requestObj = {
		name: name,
		questions: questionArr
	};
	console.log(JSON.stringify(requestObj));
	$.ajax({
		beforeSend: function(req){
			req.setRequestHeader("Content-Type", "application/json");
		},
		type: "POST",
		url: window.location.href + "api/v2/questionary",
		data: JSON.stringify(requestObj),
		success: function(data){
			questionaryId = data.questionaryId;
			$("#thankModal").modal("show");
		},
		error: function(xhr, msg){
			alert(msg+": "+xhr.status);
		}
	});
});