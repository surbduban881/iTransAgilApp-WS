USE [iTransAgiliApp]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 07/12/2016 11:07:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[idUsuario] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](100) NULL,
	[contrasena] [varchar](1000) NULL,
	[fechaRegistro] [datetime] NULL,
	[fechaUltimaModificacion] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF