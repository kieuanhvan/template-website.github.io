create database asmjava4Test;
use asmjava4Test;

select * from history;
select * from user;
select * from video;

select v.id, v.title ,v.href ,  sum(cast(h.isLiked  as SIGNED)) as `like` from history h
inner join user u on u.id = h.userId
right join video v on v.id = h.videoId
where v.isActive = 1
group by v.title ,v.href
order by sum(cast(h.isLiked  as SIGNED)) desc;

create table user(
	id int primary key auto_increment,
    username varchar(10) unique ,
    password varchar(10),
    email varchar(50),
    isAdmin bit default 0, /*khong phai admin*/
    isActive bit default 1
);
ALTER TABLE person ADD COLUMN age INT;

create table video(
	id int primary key auto_increment,
    title varchar(255),
    href varchar(50) ,
    posters varchar(255),
    views int default 0,
    shares int  default 0,
    descriptions varchar(255),
    isActive bit default 1
);

create table history (
		id int primary key auto_increment,
        userId int ,
        videoId int ,
        viewDate datetime default CURRENT_TIMESTAMP,
        isLiked bit default 0 ,
        likeDate datetime,
        foreign key (userId) references user(id),
         foreign key (videoId) references video(id)
);

insert into user (username, password ,email,isAdmin ) values
('vanka' , '123','anhvan@gmail.com' , 1),
('huongtt' , '222','anhvan12@gmail.com' , 0);

insert into video(title,href,descriptions) values 
('music 1' , 'CihmFK_vg_I' , 'Hip Hop/Trap Instrumental Beats Mix 2019  | 1 HOUR Hip Hop Instrumentals Beats Mix 2022 beat'),
('music 2' , 'vGJX2e4YXgc' , 'DANCIN REMIX - WAY BACK HOME REMIX - NHẠC HOT TREND TIKTOK GÂY NGHIỆN'),
('NƠI NÀY CÓ ANH | OFFICIAL MUSIC VIDEO | SƠN TÙNG M-TP' , 'FN7ALfpGxiI' , 'Các đơn vị báo chí muốn đăng tải thông tin liên quan vui lòng liên hệ M-TP Entertainment để được xác nhận đăng Video
Theo dõi kênh YouTube Sơn Tùng M-TP để được cập nhật thông tin'),
('music 4' , '-JBrqp6MM48' , 'Illustration by:alcd');


insert into history(userId , videoId ,isLiked , likeDate) values 
(1,1,1,now()),
(1,3,0,null);

 DROP procedure IF EXISTS `findUsersByHref`;
DELIMITER $$
CREATE PROCEDURE `findUsersByHref` (IN f_href varchar(50))
begin 
	select distinct u.* from history h
    inner join user u on u.id = h.userId
     inner join video v on v.id = h.videoId
     
    where v.href = f_href and u.isActive = 1 and v.isActive = 1;
END$$
DELIMITER ;
call findUsersByHref('CihmFK_vg_I');

