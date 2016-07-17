USE [iTransAgiliApp]
GO
/****** Object:  StoredProcedure [dbo].[RegistrarUsuario]    Script Date: 07/12/2016 09:27:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Harold Stevens Espitia Paz
-- Create date: 11/07/2016
-- Description:	Retorna los códigos de respuesta configurados
-- =============================================
CREATE PROCEDURE [dbo].[GetResponseCodes] 
AS
BEGIN
	SELECT * FROM [dbo].[ResponseCodes]
END