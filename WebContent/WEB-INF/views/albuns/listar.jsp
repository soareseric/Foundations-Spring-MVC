<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Listagem de albuns</h2>
<br />
<div class="row">
	<div class="col-md-10">
		<div class="form-group">
			<label>�lbum a ser pesquisado</label>
			<input type="text" id="txt-pesquisa" class="form-control">
		</div>
		<button class="btn btn-default" id="btn-pesquisar">Pesquisar</button>
	</div>
</div>
<table class="table" id="tbl-albuns">
	<thead>
		<th>ID</th>
		<th>Nome do �lbum</th>
		<th>Ano de Lan�amento</th>
		<th>A��es</th>
	</thead>
	<tbody>
		<c:if test="${!empty albuns}">
			<c:forEach items="${albuns}" var="album">
				<tr>
					<td>${album.id}</td>
					<td>${album.nome}</td>
					<td>${album.anoDeLancamento}</td>
					<td>
						<a href="/spring-mvc/albuns/alterar/${album.id}">Alterar</a> |
						<a href="/spring-mvc/albuns/excluir/${album.id}">Excluir</a> |
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<br/>
<a href="/spring-mvc/albuns/adicionar" class="btn btn-default">Adicionar novo �lbum</a>

<script type="text/javascript">
	$(document).ready(function(){
		$('#btn-pesquisar').click(function() {
			var nomeAlbum = $('#txt-pesquisa').val();
			$.ajax({
				method: 'GET', 
				url: '/spring-mvc/albuns/porNome/' + nomeAlbum,
				success: function(data) {
					$('#tbl-albuns tbody > tr').remove();
					$('#tbl-albuns tbody').append(
						'<tr>' +
						'	<td>' + data.id + '</td>' +
						'	<td>' + data.nome + '</td>' +
						'	<td>' + data.anoDeLancamento + '</td>' +
						'	<td>' +
						'		<a href="/spring-mvc/albuns/alterar/' + data.id + '">Alterar</a> |' +
						'		<a href="/spring-mvc/albuns/excluir/' + data.id + '">Excluir</a>' +
						'	</td>' +	
						'</tr>'
					);
				},
				error: function() {
					alert("Houve um erro na requisi��o");
				}
			});
		});
	});
</script>