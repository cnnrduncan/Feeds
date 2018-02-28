/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  cnnrd
 * Created: Aug 5, 2017
 */

create table Feeds (
ID integer(10000) not null unique,
FeedName varchar(50) not null,
Picture varchar(256),
NumSubs integer(10),
NumPosts integer(10000),

PRIMARY KEY (ID),

);

create table Users (
Username varchar(32) not null unique,
Password varchar(32) not null,
Picture varchar(256),
Bio varchar(2000),
Nickname varchar(32),

PRIMARY KEY (Username),

);

create table Posts (
ID integer(10000) not null unique,
postText char(10000),
Score integer(100000),
PosterID varchar(32),

PRIMARY KEY (ID),

);

create table Attatchments (
PostID integer(10000),
URL varchar(256) not null,

FOREIGN KEY (PostID) REFERENCES Posts(ID),

PRIMARY KEY (PostID, URL),

);

create table Feed_Posts (
PostID integer(10000),
FeedID integer(10000),

FOREIGN KEY (PostID) REFERENCES Posts(ID),
FOREIGN KEY (FeedID) REFERENCES Feeds(ID),

PRIMARY KEY (PostID, FeedID),

);

create table Feed_Admins (
FeedID integer(10000),
Username varchar(32),

FOREIGN KEY (FeedID) REFERENCES Feeds(ID),
FOREIGN KEY (Username) REFERENCES Users(Username),

PRIMARY KEY (FeedID, Username),

);

create table User_Subscriptions (
FeedID integer(10000),
Username varchar(32),

FOREIGN KEY (FeedID) REFERENCES Feeds(ID),
FOREIGN KEY (Username) REFERENCES Users(Username),

PRIMARY KEY (FeedID, Username)

);

create table User_Friends(
Username varchar(32),
FriendUsername varchar(32),

FOREIGN KEY (Username) REFERENCES Users(Username),
FOREIGN KEY (FriendUsername) REFERENCES Users(Username),

PRIMARY KEY (Username, FriendUsername)

);

create table Post_Parents(
PostID integer(10000),
ParentID integer(10000),

FOREIGN KEY (PostID) REFERENCES Posts(ID),
FOREIGN KEY (ParentID) REFERENCES Posts(ID),

PRIMARY KEY (PostID, ParentID)

);