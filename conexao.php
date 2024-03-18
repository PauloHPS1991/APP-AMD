<?php

	$dsn="mysql:host=localhost;dbname=id10581753_bancodados;charset=utf8";
	$usuario = "";
	$senha = "";

	try{
			$PDO = new PDO($dsn, $usuario, $senha);
			//echo"Funcionou";
	}catch (PDOException $erro){
			//echo "Erro" . $erro->getMessage();
			echo"conexao_erro";
			exit;
	}
	
?>
