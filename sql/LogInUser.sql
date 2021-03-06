USE [iTransAgiliApp]
GO
/****** Object:  StoredProcedure [dbo].[LogearUsuario]    Script Date: 07/12/2016 11:05:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Harold Stevens Espitia Paz
-- Create date: 10/07/2016
-- Description:	Registro de usuario en la base de datos
-- =============================================
CREATE PROCEDURE [dbo].[LogInUser] 
	@user VARCHAR(100), 
	@password VARCHAR(100) 
AS
BEGIN
	
	IF ((SELECT COUNT(*) FROM Users WHERE email = @user AND contrasena = @password) > 0) 
	BEGIN
		SELECT '00100' AS 'responseCode';
		RETURN
	END
	ELSE
		SELECT '00102' AS 'responseCode';
		RETURN
END
