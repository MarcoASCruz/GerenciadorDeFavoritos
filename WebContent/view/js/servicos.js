var servicos = {
	buscarArquivos: function(idPasta, onSuccess){
		mapper.services.buscarArquivos(
			idPasta
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	buscarFavorito: function(idFavorito, onSuccess) {
		mapper.services.buscarArquivos(
			idFavorito
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	adicionarPasta: function(pasta, onSuccess) {
		mapper.services.adicionarPasta(
			pasta
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	alterarPasta: function(pasta, onSuccess) {
		mapper.services.alterarPasta(
			pasta
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	removerPasta: function(id, onSuccess) {
		mapper.services.removerPasta(
			id
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	adicionarFavorito: function(favorito, onSuccess) {
		mapper.services.adicionarFavorito(
			favorito
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	alterarFavorito: function(favorito, onSuccess) {
		mapper.services.alterarFavorito(
			favorito
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	removerFavorito: function(id, onSuccess) {
		mapper.services.removerFavorito(
			id
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	atualizarAcesso: function(id, onSuccess) {
		mapper.services.atualizarAcesso(
			id
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	recemAcessados: function(onSuccess) {
		mapper.services.recemAcessados(
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	maisAcessados: function(onSuccess) {
		mapper.services.maisAcessados(
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	recemAdicionados: function(onSuccess) {
		mapper.services.recemAdicionados(
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	buscarHierarquiaDePastas: function(onSuccess) {
		mapper.services.buscarHierarquia(
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	//form, precisa ter a imagem e o id do favorito destino
	uploadImagemFavorito: function(form, onSuccess) {
		mapper.services.uploadImagemFavorito(
			form
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
	,
	//form, precisa ter a imagem e o id do pasta destino
	uploadImagemPasta: function(form, onSuccess) {
		mapper.services.uploadImagemPasta(
			form
			,
			onSuccess
			,
			function(data){
				console.log(data.responseJSON);
				var modal = Element.ConfirmModal("erro", data.responseText, function(){});
				modal.show();
			}
		)
	}
}