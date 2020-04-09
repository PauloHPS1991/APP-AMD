<?php

	$dsn="mysql:host=localhost;dbname=id10581753_bancodados;charset=utf8";
	$usuario = "id10581753_root";
	$senha = "Paulo@35422859";

	try{
			$PDO = new PDO($dsn, $usuario, $senha);
			//echo"Funcionou";
	}catch (PDOException $erro){
			//echo "Erro" . $erro->getMessage();
			echo"conexao_erro";
			exit;
	}
	
?>