<?php

	include"conexao.php";
	
	
	$nome = $_POST['nome_app'];
	$telefone = $_POST['telefone_app'];
	$email = $_POST['email_app'];
	$cartao = $_POST['cartao_app'];
	
	$sql_verificar = "SELECT cartao FROM cliente WHERE cartao = :CARTAO";
	$stmt = $PDO->prepare($sql_verificar);
	$stmt->bindParam(':CARTAO', $cartao);
	$stmt->execute();
	
	if($stmt->rowCount() > 0){
		//email ja cadastrado
		$retornaAPP = array("CADASTRO"=>"CARTAO_ERRO");
	}else {
		//vai ser cadastrado
		$sql_insert = "INSERT INTO cliente (nome, telefone, email, cartao)VALUES (:NOME, :TELEFONE, :EMAIL, :CARTAO); ";
		$stmt = $PDO->prepare($sql_insert);
		$stmt->bindParam(':NOME',$nome);
		$stmt->bindParam(':TELEFONE',$telefone);
		$stmt->bindParam(':EMAIL',$email);
		$stmt->bindParam(':CARTAO',$cartao);
		
		if($stmt->execute()){
			$retornaAPP = array("CADASTRO"=>"SUCESSO");
		}else{
			$retornaAPP = array("CADASTRO"=>"ERRO");
		}
	}
	echo json_encode($retornaAPP);
?>