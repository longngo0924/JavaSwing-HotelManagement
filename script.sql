USE [master]
GO
/****** Object:  Database [QuanLyKhachSan]    Script Date: 4/13/2022 10:20:59 PM ******/
CREATE DATABASE [QuanLyKhachSan]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyKhachSan', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QuanLyKhachSan.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyKhachSan_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QuanLyKhachSan_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [QuanLyKhachSan] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyKhachSan].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyKhachSan] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyKhachSan] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyKhachSan] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLyKhachSan] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyKhachSan] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyKhachSan] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyKhachSan] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO


EXEC sys.sp_db_vardecimal_storage_format N'QuanLyKhachSan', N'ON'
GO

USE [QuanLyKhachSan]
GO
/****** Object:  Table [dbo].[ChiTietThuePhong]    Script Date: 4/13/2022 10:20:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietThuePhong](
	[maPhong] [nvarchar](30) NULL,
	[maKh] [nvarchar](30) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/13/2022 10:20:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[makh] [nvarchar](30) NOT NULL,
	[tenkh] [nvarchar](30) NULL,
	[CMND] [nvarchar](30) NULL,
	[diachi] [nvarchar](30) NULL,
	[sdt] [nvarchar](30) NULL,
	[gioitinh] [bit] NULL,
	[tuoi] [int] NULL,
	[email] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[makh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 4/13/2022 10:20:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[tenLoaiPhong] [nvarchar](20) NOT NULL,
	[gia] [float] NULL,
	[mota] [nvarchar](80) NULL,
PRIMARY KEY CLUSTERED 
(
	[tenLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 4/13/2022 10:20:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [nvarchar](30) NOT NULL,
	[tangPhong] [nvarchar](30) NULL,
	[maLoaiPhong] [nvarchar](20) NULL,
	[trangThai] [bit] NULL,
	[ghiChu] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[KhachHang] ([makh], [tenkh], [CMND], [diachi], [sdt], [gioitinh], [tuoi], [email]) VALUES (N'1223', N'lyphiminh ', N'1223', N'123', N'123123', 1, 14, N'123')
INSERT [dbo].[KhachHang] ([makh], [tenkh], [CMND], [diachi], [sdt], [gioitinh], [tuoi], [email]) VALUES (N'123123', N'12312 ', N'123123', N'123', N'123', 1, 212312, N'123123')
GO
INSERT [dbo].[LoaiPhong] ([tenLoaiPhong], [gia], [mota]) VALUES (N'Cao Cấp', 500, N'Điều hoà,')
INSERT [dbo].[LoaiPhong] ([tenLoaiPhong], [gia], [mota]) VALUES (N'Tiêu Chuẩn', 500, N'Quạt')
GO
INSERT [dbo].[Phong] ([maPhong], [tangPhong], [maLoaiPhong], [trangThai], [ghiChu]) VALUES (N'1', N'1', N'Cao Cấp', 0, N'1')
INSERT [dbo].[Phong] ([maPhong], [tangPhong], [maLoaiPhong], [trangThai], [ghiChu]) VALUES (N'10', N'1', N'Cao Cấp', 1, N'1')
INSERT [dbo].[Phong] ([maPhong], [tangPhong], [maLoaiPhong], [trangThai], [ghiChu]) VALUES (N'3', N'1', N'Cao Cấp', 0, N'')
INSERT [dbo].[Phong] ([maPhong], [tangPhong], [maLoaiPhong], [trangThai], [ghiChu]) VALUES (N'4', N'5', N'Tiêu Chuẩn', 0, N'2`12')
INSERT [dbo].[Phong] ([maPhong], [tangPhong], [maLoaiPhong], [trangThai], [ghiChu]) VALUES (N'5', N'5', N'Cao Cấp', 0, N'')
INSERT [dbo].[Phong] ([maPhong], [tangPhong], [maLoaiPhong], [trangThai], [ghiChu]) VALUES (N'6', N'5', N'Cao Cấp', 0, N'1')
GO
ALTER TABLE [dbo].[ChiTietThuePhong]  WITH CHECK ADD  CONSTRAINT [fk_maKh] FOREIGN KEY([maKh])
REFERENCES [dbo].[KhachHang] ([makh])
GO
ALTER TABLE [dbo].[ChiTietThuePhong] CHECK CONSTRAINT [fk_maKh]
GO
ALTER TABLE [dbo].[ChiTietThuePhong]  WITH CHECK ADD  CONSTRAINT [fk_maPHong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[ChiTietThuePhong] CHECK CONSTRAINT [fk_maPHong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [fk_Phong] FOREIGN KEY([maLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([tenLoaiPhong])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [fk_Phong]
GO
USE [master]
GO
ALTER DATABASE [QuanLyKhachSan] SET  READ_WRITE 
GO

use QuanLyKhachSan

alter table ChiTietThuePhong ADD FOREIGN KEY(maPhong) REFERENCES  Phong(maPhong)

alter table ChiTietThuePhong ADD FOREIGN KEY(maKhachHang) REFERENCES  KhachHang(makh)

select * from ChiTietThuePhong

select * from Phong

select * from KhachHang

select * from ChiTietThuePhong where ngayDen >= '2022-04-04' and ngayDen <= '2022-12-12'

select distinct maKhachHang from ChiTietThuePhong

ALTER TABLE ChiTietThuePhong
ADD tienDichVu float
