create database Poly;
use Poly;
create table users
(
	username varchar(20) primary key,
	password varchar(50),
	email	varchar(50),
	fullname nvarchar(50),
	admin bit
);
create table videos(
	videoid varchar(50) primary key,
	title nvarchar(100),
	poster	nvarchar(150),
	views int,
	decription nvarchar(1500),
	active bit
);

create table favorite(
	favoriteid int identity(1,1) primary key,
	username varchar(20) references users(username),
	videoid	varchar(50) references videos(videoid),
	likedate date
);
create table shares(
	shareid int identity(1,1) primary key,
	username varchar(20) references users(username),
	videoid	varchar(50) references videos(videoid),
	email	nvarchar(250),
	sharedate date
);
