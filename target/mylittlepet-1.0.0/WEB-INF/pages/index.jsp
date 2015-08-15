<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<title>MyLittlePetApp</title>

	<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />
	<spring:url value="/resources/css/bootstrap-responsive.css" var="bootstrapResponsive" />
	<spring:url value="/resources/css/flattern.css" var="flattern" />
	<spring:url value="/resources/css/flattern-responsive.css" var="flatternResponsive" />
	<spring:url value="/resources/css/style.css" var="style" />
	<spring:url value="/resources/css/style-responsive.css" var="styleResponsive" />

	<link href="${bootstrap}" rel="stylesheet" type="text/css" />
	<link href="${bootstrapResponsive}" rel="stylesheet" type="text/css" />
	<link href="${flattern}" rel="stylesheet" type="text/css" />
	<link href="${flatternResponsive}" rel="stylesheet" type="text/css" />
	<link href="${style}" rel="stylesheet" type="text/css" />
	<link href="${styleResponsive}" rel="stylesheet" type="text/css" />
	
	<spring:url value="/resources/js/jquery-latest.min.js" var="jquery" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrap" />
	<spring:url value="/resources/js/flattern.js" var="flattern" />

	<script type="text/javascript" src="${jquery}"></script>
	<script type="text/javascript" src="${bootstrap}"></script>
	<script type="text/javascript" src="${flattern}"></script>
</head>

<body>

	<div id="content">
		<section id="header" class="dark-purple">

		<div class="top-header container">

			<div class="row">

				<div class="span6">
					<a class="logo" href="#">MyLittlePetAPP</a>
				</div>

				<div class="span6">
					<a class="pull-right" href="mailto:#">MyLittlePetAPP@gmail.com</a>
				</div>

			</div>

		</div>

		<div class="banner container">

			<div class="row">

				<div class="span7 left-marketing">

					<h1 class="uppercase">Faça o controle da vida do seu Pet com
						esse APP</h1>

					<p class="lead">Com o MyLittlePetAPP você mantém todas as
						informações necessárias para controlar e cuidar da vida do seu
						bichinho de estimação.</p>

					<a href="#"><img src="<c:url value="/resources/img/playstore.png" />" alt="Play Store" class="store-button" /></a>

				</div>

				<div class="span5">
					<img src="<c:url value="/resources/img/celular1.png" />" alt="MyLittlePetAPP"  />
				</div>

			</div>

		</div>
		</section>

		<section id="featurettes">

		<div class="top-featurette">

			<div class="container">

				<div class="row">

					<div class="span7">

						<h1>Crie seu pingente.</h1>
						<p class="lead">Utilizamos a Tecnologia QR Code, com ela
							podermos saber todas as informações do seu PET, ajudando a
							localizar o dono caso o Pet esteja perdido</p>
						<p class="lead">Basta utilizar o leitor de código de barras/qr
							code do seu celular para poder acessar as informações do PET.</p>
					</div>

					<div class="span5">
						<img src="<c:url value="/resources/img/qrcode.png" />" class="featurette-image" alt="Localização" />
					</div>

				</div>

			</div>

		</div>

		<div class="middle-featurette">

			<div class="container">

				<div class="row">

					<div class="span5">
						<img src="<c:url value="/resources/img/black-iphone.png" />" alt="MyLittlePetAPP" class="featurette-image" />

					</div>

					<div class="span7">

						<h1>Perfil completo e sem restrições..</h1>
						<p class="lead">Quer um perfil com mais funcionalidades e com
							total controle?</p>
						<p class="lead">Baixe a versão Premium do aplicativo, que
							contém cadastros ilimitados e sem propagandas.</p>
						<h2 class="centered">
							<a href="#">
								<img src="<c:url value="/resources/img/playstore.png" />" class="featurette-image" alt="Play Store" />
							</a>
						</h2>
					</div>

				</div>

			</div>

		</div>

		<div class="bottom-featurette">

			<div class="container">

				<div class="row">

					<div class="span7">

						<h1>Toda informação é segura.</h1>
						<p>Fique tranquilo, todas as informações pessoais e do seu pet
							estará totalmente seguras, somente você terá as informações.</p>
						<p>As únicas informações públicas ficarão salvas no QR Code,
							mas apenas para ajudá-los a encontar seu pet.</p>

						<a href="#" class="button-large turqoise uppercase">Baixe
							agora o APP</a>

					</div>

					<div class="span5">
						<img src="<c:url value="/resources/img/safe.png" />" alt="App Seguro" class="featurette-image" />
					</div>

				</div>

			</div>

		</div>
		</section>

		<section id="testimonials" class="turqoise">

		<div class="container">

			<div class="row">

				<h3 class="centered uppercase">Print das Telas</h3>
				<img src="<c:url value="/resources/img/print.png" />" alt="Print" />
				<img src="<c:url value="/resources/img/print.png" />" alt="Print" />
				<img src="<c:url value="/resources/img/print.png" />" alt="Print" />
				<img src="<c:url value="/resources/img/print.png" />" alt="Print" />
			</div>

		</div>

		</section>

		<section id="subscribe" class="bright-pink">

		<div class="container">

			<div class="row">
				<h3 class="centered uppercase">Precisa de uma conta?</h3>
				<h2 class="centered">Faça o download do aplicativo para
					inscrever-se.</h2>
				<h2 class="centered">
					<a href="#">
						<img src="<c:url value="/resources/img/playstore.png" />" class="store-button" alt="Play Store" />
					</a>
				</h2>
			</div>

		</div>

		</section>

		<!-- Footer -->
		<section id="footer" class="dark-purple">

		<div class="container">

			<div class="row">

				<h3 class="centered">Nos siga nas Redes Sociais</h3>

				<div class="footer-icons">
					<ul class="social-icons">
						<li><a href="#" class="purple-twitter">Twitter</a></li>
						<li><a href="https://www.facebook.com/mylittlepetapp"
							class="purple-facebook" target="_blank">facebook</a></li>
						<li><a href="#" class="purple-instagram">Instragram</a></li>
						<li><a href="#" class="purple-linkedin">linkedin</a></li>
					</ul>
				</div>

				<div class="span12 copyright">
					<p>Copyright © 2015 MyLittlePetAPP. Todos os direitos	reservados.</p>
				</div>

			</div>

		</div>

		</section>
		<!--/ #Footer -->

		<div class="toTop">
			<a href="#">top</a>
		</div>
	</div>
</body>
</html>