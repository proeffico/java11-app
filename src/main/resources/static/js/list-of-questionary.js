
$("#openBtn").click(function() {
	
	console.log("clicked")
	var header = $("#questionarySelect option:selected").text()
	var questionaryId = $("#questionarySelect option:selected").val()
	
	var chosenQuestionary = questionaries.find(function(q){ 
		return q.questionaryId == questionaryId
	})
	
	var questionsOfChosenQuestionary = chosenQuestionary.questions; //[]
	$("form-to-show-onclick").show()
	$("table.table.table-bordered").show();
	$("#questionaryHeader").append(
			'<h1 class="text-center">'+header+'</h1>'
			)
	
	console.log(questionsOfChosenQuestionary)
	
	//me halutaan luoda jokaisesta questionsOfChosenQuestionary taulukon oliosta oma table row
	var lkm = 0
	
	let rows = questionsOfChosenQuestionary.map(function(question){
		lkm++
		var questionStr = question.question
		var questionType = question.questionType.type
		var questionId = question.questionId
		var buttonStr = "Edit"
		return (
				'<tr id="'+lkm+'Tr">'+
			       '<th scope="row">'+lkm+'</th>'+
			       '<td colspan="3" class="questionTd" data="'+questionId+'">'+questionStr+'</td>'+
			       '<td>'+questionType+'</td>'+
			       '<td class="text-center"><span class="oi oi-circle-x" title="icon name" aria-hidden="true" data="#'+lkm+'Tr"></span></td>'+
			       '<td class="text-center"><button type="button" class="btn btn-primary editButton" data-toggle="modal" data-target="#exampleModal.questionText" data="'+questionStr+'">'+buttonStr+'</button><td>'+
				'</tr>'
		)
	})
	
	$("#questionListTbody").append(rows)
	
})

$( document ).on("click", ".editButton",function() {
	//täällä täytyy pystyä, toimittamaan sinne modalin bodyyn näitä kysesien rivin attribuutteja, jotta saadaan näytettyä
	//sitä muokattavan kysymyksen informaatiota siinä avautuvassa modaalissa.
	//Lisäksi täytyy tehdä PUT kutsu rest osoitteeseen kun tietoja on muokattu.
	//haluamme tarjota käyttäjälle mahdollisuus muokata kysymysTekstiä, sekä kysymystyyppiä 
	//eli mun pitää täällä jotenkin saada kiinni sen klikatun rivin kysymys, kysymystyyppi ja varmaan myös se id, jotta 
	//voidaan tehdä PUT request, mutta miten saan nämä tiedot?
	//missä ne ovat nyt?? -- ne ovat tällä hetkellä <tr> tagin arvoissa ja attribuuteissa
	
	var questionStr = this.data
	console.log(questionStr)
	
	
	
	
})




