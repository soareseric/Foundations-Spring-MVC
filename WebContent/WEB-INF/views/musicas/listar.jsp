<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Listagem de albuns</h2>
<br />
<table class="table">
	<thead>
		<th>ID</th>
		<th>Nome da m�sica</th>
		<th>Data de cria��o</th>
		<th>Nome do �lbum</th>
		<th>A��es</th>
	</thead>
	<tbody>
		<c:if test="${!empty musicas}">
			<c:forEach items="${musicas}" var="album">
				<tr>
					<td>${musica.id}</td>
					<td>${musica.nome}</td>
					<td>${musica.dataCriacao}</td>
					<td>${musica.album.nome}</td>
					<td>
						<a href="/spring-mvc/albuns/alterar/${musica.id}">Alterar</a> |
						<a href="/spring-mvc/albuns/excluir/${musica.id}">Excluir</a> |
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<br/>
<a href="/spring-mvc/musicas/adicionar" class="btn btn-default">Adicionar novo M�sica</a>