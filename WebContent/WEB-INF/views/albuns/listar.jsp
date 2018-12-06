<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Listagem de albuns</h2>
<br />
<table class="table">
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
						<a href="/albuns/alterar/${album.id}">Alterar</a> |
						<a href="/albuns/excluir/${album.id}">Excluir</a> |
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<br/>
<a href="/albuns/adicionar" class="btn btn-default">Adicionar novo �lbum</a>