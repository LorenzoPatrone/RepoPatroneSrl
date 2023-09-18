<div class="container">
<div class="card w-50 mx-auto my-5">
<div class="card-header text-center">Signup</div>
<div class="card-body">
<form action="signup" method="POST">
<p> ${formerror}</p>
<div class="form-group">
     <label for="firstname">Nome</label>
     <input type="text" class="form-control" name="firstname" placeholder="Enter Your Name..." required>
</div>
<div class="form-group">
     <label for="lastname">Cognome</label>
     <input type="text" class="form-control" name="lastname" placeholder="Enter Your Surname..." required>
</div>
<div class="form-group">
     <label for="address">Indirizzo</label>
     <input type="text" class="form-control" name="address" placeholder="Enter Your Address..." required>
</div>
<div class="form-group">
     <label for="email">Email</label>
     <input type="email" class="form-control" name="email" placeholder="Enter Your Email..." 
     pattern="^[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z]+)+$" 
     title="Il campo email deve contenere lettere minuscole e maiuscole, numeri e può includere simboli." required>
</div>
<div class="form-group">
     <label for="password">Password</label>
     <input type="password" class="form-control" 
     name="password" placeholder="Enter Your Password..." 
     pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$" 
     title="Il campo password deve contenere un minimo di 8 caratteri, maiuscole e minuscole, numeri e almemo un carattere speciale." required>
</div>
<div>
	<p> </p>
</div>
<div class="text-center">
     <button type="submit" class="btn btn-success">Confirm</button>
     <button type="reset" class="btn btn-secondary">Reset</button>
</div>
</form>
</div>
<div class="mx-auto" style="width: 300px;">
	<div class="text-center">
	<h6>Sei già iscritto? <a href="login.jsp">Accedi</a></h6>
	</div>
</div>
</div>
</div>