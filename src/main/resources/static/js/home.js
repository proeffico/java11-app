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

$("#thankModal").on("hidden.bs.modal", function(){
	location.reload();
});

$("#createBtn").click(function(){
	$("#thankModal").modal("show");
});