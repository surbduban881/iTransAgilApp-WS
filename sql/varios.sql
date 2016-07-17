-- -----------------------------------------
-- Ejecutar Registro de usuario
-- -----------------------------------------
USE [iTransAgiliApp]
GO
DECLARE	@return_value int,
		@responseCode varchar(5)

EXEC	@return_value = [dbo].[RegistrarUsuario]
		@user = N'p@1.com',
		@password = N'123',
		@responseCode = @responseCode OUTPUT

SELECT	@responseCode as N'@responseCode'
SELECT	'Return Value' = @return_value
GO

-- -----------------------------------------
-- Ejecutar Logueo de usuario
-- -----------------------------------------
USE [iTransAgiliApp]
GO
DECLARE	@return_value int,
		@responseCode varchar(5)

EXEC	@return_value = [dbo].[LogearUsuario]
		@user = N'p@1.c',
		@password = N'123',
		@responseCode = @responseCode OUTPUT

SELECT	@responseCode as N'@responseCode'
SELECT	'Return Value' = @return_value
GO


-- -----------------------------------------
-- Reiniciar tabla usuarios
-- -----------------------------------------
DELETE FROM Users
DBCC CHECKIDENT (Users, RESEED, 0)