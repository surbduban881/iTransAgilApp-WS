USE [iTransAgiliApp]
GO
/****** Object:  Table [dbo].[ResponseCodes]    Script Date: 07/12/2016 11:01:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[ResponseCodes](
	[code] [varchar](5) NULL,
	[description] [varchar](100) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF

/* ===============================================
* DATA 
* ================================================
*/
INSERT INTO ResponseCodes VALUES ('00100', 'Transaccion Exitosa');
INSERT INTO ResponseCodes VALUES ('00101', 'Usuario ya registrado');
INSERT INTO ResponseCodes VALUES ('00102', 'Credenciales inválidas');
