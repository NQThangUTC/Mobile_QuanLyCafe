GetAccount = "Select * From Account Where UserName = ? AND PassWord = ?"
GetLogin = "exec USP_Login @userName = ?, @passWord = ?"
checkUser = "Select COUNT(*) from Account WHERE UserName = ?"
InsertAccount = "exec SP_InsertAccount @UserName = ?, @DisplayName=?, @Pass = ?,@RePass = ?, @Type = ?"