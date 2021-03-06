USE [iTransAgiliApp]
GO
/****** Object:  StoredProcedure [dbo].[RegistrarUsuario]    Script Date: 07/12/2016 11:04:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Harold Stevens Espitia Paz
-- Create date: 10/07/2016
-- Description:	Registro de usuario en la base de datos
-- =============================================
CREATE PROCEDURE [dbo].[RegisterUser] 
	@user VARCHAR(100), 
	@password VARCHAR(100)
AS
BEGIN
	
	IF ((SELECT COUNT(*) FROM Users WHERE email = @user) > 0) 
	BEGIN
		SELECT '00101' AS 'responseCode';
		RETURN;
	END
	ELSE
		SELECT '00100' AS 'responseCode';		
		INSERT INTO Users (email, contrasena, fechaRegistro, fechaUltimaModificacion)
			VALUES (@user, @password, GETDATE(), GETDATE());
		
		RETURN;	
END