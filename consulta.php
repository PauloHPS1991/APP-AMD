<?php

	include"conexao.php";
	
	
	$nome = $_POST['nome_app'];
	$especialidade = $_POST['especialidade_app'];

		
		$sql_insert = "SELECT nome, especialidade FROM meico";
		$stmt = $PDO->prepare($sql_insert);
		$stmt->bindParam(':NOME',$nome);
		$stmt->bindParam(':ESPECIALIDADE',$especialidade);
		
		$retornaAPP = array("CADASTRO"=>"SUCESSO");
		
	echo json_encode($retornaAPP);
?>