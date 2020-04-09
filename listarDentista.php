<?php
	$con = mysqli_connect("localhost","id10581753_root","Paulo@35422859","id10581753_bancodados") or die ("Sem conexao");
	$sql = "SELECT nome, especialidade FROM medico";
	$dados = Array();
	$result = mysqli_query($con,$sql);
	while($row = mysqli_fetch_object($result)){
		$dados[] = $row;
	}
	echo json_encode($dados);
	mysqli_close($con);
?>