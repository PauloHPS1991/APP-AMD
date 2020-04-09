<?php

	include"conexao.php";
	
	$cartao = $_POST['cartao_app'];
	
	$sql_verificar = "SELECT cartao FROM cliente WHERE cartao = :CARTAO";
	$stmt = $PDO->prepare($sql_verificar);
	$stmt->bindParam(':CARTAO', $cartao);
	$stmt->execute();
	
	if($stmt->rowCount() > 0){
		//email ja cadastrado
		$retornaAPP = array("LOGIN"=>"SUCESSO");
	}else {
		$retornaAPP = array("LOGIN"=>"ERRO");
	}
	
	echo json_encode($retornaAPP);
	
	?>