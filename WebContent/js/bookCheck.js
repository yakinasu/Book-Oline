function CheckBlank(){
	var isbn = document.getElementById('isbn');
	var title = document.getElementById('title');
	var page = document.getElementById('page');
	var author = document.getElementById('author');
	var ErrorMSG = document.getElementById('errorMSG');
	var flag = 0;

	if (title.value == ""){
		ErrorMSG.innerHTML += 'isbnは必須です<br>';
		flag = 1;
	}
	if (isbn.value == ""){
		ErrorMSG.innerHTML = 'BookTitleは必須です<br>';
		flag = 1;
	}
	if (page.value == ""){
		ErrorMSG.innerHTML += 'Pageは必須です<br>';
		flag = 1;
	}
	if (author.value == ""){
		ErrorMSG.innerHTML += 'Authorは必須です<br>';
		flag = 1;
	}
	if(flag){
		return false;
	}
	alert("本情報を登録しました。");
	return true;
}