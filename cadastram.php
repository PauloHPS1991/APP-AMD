<?php

	include"conexao.php";
	
	
	$nome = $_POST['nome_app'];
	$telefone = $_POST['telefone_app'];
	$email = $_POST['email_app'];
	$endereco = $_POST['endereco_app'];
	$especialidade = $_POST['especialidade_app'];
	
	$sql_verificar = "SELECT telefone FROM medico WHERE telefone = :TELEFONE";
	$stmt = $PDO->prepare($sql_verificar);
	$stmt->bindParam(':TELEFONE', $telefone);
	$stmt->execute();
	
	if($stmt->rowCount() > 0){
		//email ja cadastrado
		$retornaAPP = array("CADASTRO"=>"CARTAO_ERRO");
	}else {
		//vai ser cadastrado
		$sql_insert = "INSERT INTO medico (nome, telefone, email, endereco, especialidade)VALUES (:NOME, :TELEFONE, :EMAIL, :ENDERECO, :ESPECIALIDADE); ";
		$stmt = $PDO->prepare($sql_insert);
		$stmt->bindParam(':NOME',$nome);
		$stmt->bindParam(':TELEFONE',$telefone);
		$stmt->bindParam(':EMAIL',$email);
		$stmt->bindParam(':ENDERECO',$endereco);
		$stmt->bindParam(':ESPECIALIDADE',$especialidade);
		
		if($stmt->execute()){
			$retornaAPP = array("CADASTRO"=>"SUCESSO");
		}else{
			$retornaAPP = array("CADASTRO"=>"ERRO");
		}
	}
	echo json_encode($retornaAPP);
?>