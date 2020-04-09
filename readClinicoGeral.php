<?php
	include "conexao.php";
	
	$sql_read = "SELECT * FROM `medico` WHERE especialidade = 'Clinico Geral'";
	$dados = $PDO->query($sql_read);
	
	$resultado = array();
	
	while($contato = $dados->fetch(PDO::FETCH_OBJ)){
		$resultado[] = array("id"=>$contato->id, "nome"=>$contato->nome, "especialidade"=>$contato->especialidade);
	}
	echo json_encode($resultado);
	
?>