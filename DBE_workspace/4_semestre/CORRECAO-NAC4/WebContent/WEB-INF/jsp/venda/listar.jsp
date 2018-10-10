<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:template titulo="Vendas">
	<h1>Listar Vendas</h1>
	
	<table class="table table-hover">
		
		<thead>
			<tr>
				<th>Cliente</th>			
				<th>Data</th>			
				<th>Descrição</th>			
				<th>Valor</th>			
				<th>Pago</th>
				<th></th>
			</tr>
		</thead>
	
		<tbody>
			<c:forEach items="${vendas}" var="venda">
				<tr>
					<td>${venda.cliente}</td>
					<td>
						<fmt:formatDate value="${venda.data.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td>${venda.descricao}</td>
					<td>${venda.valor}</td>
					<td>${venda.pago ? "Sim" : "Não"}</td>
					<td>
						<c:if test="${venda.pago == true}">
							<button type="button" class="btn btn-outline-success" disabled="disabled">
  								Pagar
							</button>
						</c:if>
						<c:if test="${venda.pago == false}">
							<button type="button" class="btn btn-outline-success" data-toggle="modal" 
								data-target="#exampleModal" onclick="modalPagar.value = ${venda.codigo}">
								Pagar
							</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>

</tags:template>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Pagar Venda</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	Deseja realmente pagar a venda?
      </div>
      <div class="modal-footer">
      	<c:url value="/venda/pagar" var="acao"/>
      	<form action="${acao}" method="post">
      		<input type="hidden" id="modalPagar" name="codigo"/>
	        <button type="submit" class="btn btn-success">Pagar</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      	</form>
      </div>
    </div>
  </div>
</div>