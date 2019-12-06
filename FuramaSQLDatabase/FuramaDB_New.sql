drop database if exists furama_resort_tuan_c10g;
create database furama_resort_tuan_c10g;
use furama_resort_tuan_c10g;
CREATE TABLE ViTri(
	IDViTri int,
    TenViTri NVARCHAR(45) UNIQUE,
    PRIMARY KEY(IDViTri)
);
CREATE TABLE TrinhDo(
	IDTrinhDo int Primary key,
    TrinhDo NVARCHAR(45) UNIQUE
);
CREATE TABLE Bophan(
	IDBoPhan int Primary key,
    TenBoPhan NVARCHAR(45) UNIQUE
);
CREATE TABLE NhanVien(
	IDNhanVien int Primary key,
    HoTen NVARCHAR(45),
	IDVitri int,
    IDTrinhDo int,
    IDBoPhan int,
    NgaySinh DATE,
    SoCMND NVARCHAR(45) UNIQUE,
    Luong DOUBLE(11,3),
    SDT NVARCHAR(12) UNIQUE,
    Email NVARCHAR(45) UNIQUE,
    DiaChi NVARCHAR(45),
    FOREIGN KEY(IDViTri) REFERENCES vitri(IDViTri),
    FOREIGN KEY(IDTrinhDo) REFERENCES trinhdo(IDTrinhDo),
    FOREIGN KEY(IDBoPhan) REFERENCES bophan(IDBoPhan)
);
create table LoaiDichVu(
	IDLoaiDichVu int primary key,
    TenLoaiDichVu NVARCHAR(45) UNIQUE
    );
create table KieuThue(
	IDKieuThue int primary key,
    TenKieuThue NVARCHAR(45) UNIQUE,
    Gia double
    );
create table DichVu(
	IDDichVu int primary key,
    TenDichVu NVARCHAR(45),
    DienTich DOUBLE,
    SoNguoiToiDa int,
    ChiPhiThue DOUBLE(10,3),
    IDLoaiDichVu int,
    IDKieuThue int,
    TieuChuanPhong NVARCHAR(45),
    MoTaTienNghi NVARCHAR(45),
    DienTichHoBoi DOUBLE,
    SoTang int,
    TrangThai NVARCHAR(45),
    FOREIGN KEY(IDLoaiDichVu) REFERENCES LoaiDichVu(IDLoaiDichVu),
    FOREIGN KEY(IDKieuThue) REFERENCES KieuThue(IDKieuThue)
    );
create table LoaiKhach(
	IDLoaiKhach int primary key,
    TenLoaiKhach NVARCHAR(45) UNIQUE
    );
create table KhachHang(
	IDKhachHang int primary key,
    HoTen NVARCHAR(45),
    NgaySinh DATE NOT NULL,
    GioiTinh NVARCHAR(45),
    SoCMND NVARCHAR(45) UNIQUE,
    SDT NVARCHAR(45) UNIQUE,
    Email NVARCHAR(45) UNIQUE,
    IDLoaiKhach int,
    DiaChi NVARCHAR(45),
    FOREIGN KEY (IDLoaiKhach) REFERENCES LoaiKhach(IDLoaiKhach)
    );
CREATE TABLE DichVuDiKem(
	IDDichVuDiKem int primary key ,
    TenDichVuDiKem NVARCHAR(45) UNIQUE,
    Gia double,
    DonVi int,
    TrangThaiKhaDung NVARCHAR(45)
    );
CREATE TABLE HopDong(
	IDHopDong int Primary key,
    NgayLamHopDong DATE,
    NgayKetThuc DATE,
    TienDatCoc double,
    TongTien double,
    IDKhachHang int,
    IDDichVu int,
    IDNhanVien int,
    FOREIGN KEY(IDNhanVien) REFERENCES NhanVien(IDNhanVien),
    FOREIGN KEY(IDKhachHang) REFERENCES KhachHang(IDKhachHang),
    FOREIGN KEY(IDDichVu) REFERENCES DichVu(IDDichVu)
);
CREATE TABLE HopDongChiTiet(
    IDHopDong int,
    IDDichVuDiKem int,
    SoLuong int,
    primary key (IDHopDong,IDDichVuDiKem),
    FOREIGN KEY (IDHopDong) REFERENCES HopDong(IDHopDong),
    FOREIGN KEY (IDDichVuDiKem) REFERENCES DichVuDiKem(IDDichVuDiKem)
);

insert into ViTri values(1,'Trưởng phòng');
insert into ViTri values(2,'Nhân viên');
insert into TrinhDo values(1,'Đại học');
insert into TrinhDo values(2,'Cao Đẳng');
insert into Bophan values(1,'Hành chính');
insert into Bophan values(2,'Nhân sự');
insert into NhanVien values(1,'Nguyễn Văn T 123123', 1,1,1,'1988:01:01','201123451',100000,'0935123451','b1@b.com','Đà Nẵng');
insert into NhanVien values(2,'Nguyễn Văn H', 1,1,1,'1988:01:01','201123452',100000,'0935123452','b2@b.com','Đà Nẵng');
insert into NhanVien values(3,'Nguyễn Khoa C', 1,1,1,'1988:01:01','201123453',100000,'0935123453','b3@b.com','Đà Nẵng');
insert into NhanVien values(4,'Nguyễn Văn K', 1,1,1,'1988:01:01','201123454',100000,'0935123454','b4@b.com','Đà Nẵng');
insert into NhanVien values(5,'Nguyễn Văn M', 1,1,1,'1988:01:01','201123455',100000,'0935123455','b5@b.com','Đà Nẵng');
insert into NhanVien values(6,'Nguyễn Văn abc', 2,2,2,'1988:01:01','201123123',100000,'0935123457','b6@b.com','Đà Nẵng');
insert into NhanVien values(7,'Nguyễn Văn def', 2,1,2,'1988:01:01','201123456',100000,'0935123485','b7@b.com','Đà Nẵng');
insert into LoaiDichVu values(1,'Villa');
insert into LoaiDichVu values(2,'House');
insert into LoaiDichVu values(3,'Room');
insert into KieuThue values(1,'Năm',12000000);
insert into KieuThue values(2,'Tháng',1000000);
insert into KieuThue values(3,'Ngày',100000);
insert into KieuThue values(4,'Giờ',10000);
insert into DichVu values(1,'Xuan mai',50,5,5000000,1,1,'Vip','MoTaTienNghi',25,3,'San sang');
insert into DichVu values(2,'Mai Phuong',30,3,3000000,2,2,'Vip','MoTaTienNghi',15,2,'San sang');
insert into DichVu values(3,'Thanh Phong',10,4,1000000,3,3,'Vip','MoTaTienNghi',45,1,'San sang');
insert into DichVu values(4,'Tuan Thanh',10,6,1000000,3,3,'Vip','MoTaTienNghi',55,6,'San sang');
insert into DichVu values(5,'Tuan Thanh 2',10,9,1000000,3,3,'Vip','MoTaTienNghi',105,5,'San sang');

insert into LoaiKhach values(1, 'Diamond');
insert into LoaiKhach values(2, 'Platinium');
insert into LoaiKhach values(3, 'Silver');
insert into LoaiKhach values(4, 'Member');

insert into KhachHang values(1,'Nguyen Van A','1988:01:01', 0 , '201561121', '0935123451','a1@a.com', 1, 'Đà Nẵng');
insert into KhachHang values(2,'Nguyen Van K','1990:01:01', 0 , '201561122', '0935123452','a2@a.com', 2, 'Quảng Ngãi');
insert into KhachHang values(3,'Nguyen Van T','1908:01:01', 0 , '201561123', '0935123453','a3@a.com', 1, 'Vinh');
insert into KhachHang values(4,'Nguyen Van C','2000:01:01', 0 , '201561124', '0935123454','a4@a.com', 3, 'Quảng Trị');
insert into KhachHang values(5,'Nguyen Van H','1999:01:01', 0 , '201561125', '0935123455','a5@a.com', 1, 'Quảng Ngãi');
insert into KhachHang values(6,'Nguyen Van H','1994:01:01', 0 , '201561518', '0935123485','a6@a.com', 4, 'Quảng Trị');
insert into KhachHang values(7,'Nguyen Van A','1998:01:01', 0 , '201561519', '0935123475','a7@a.com', 2, 'Đà Nẵng');

insert into DichVuDiKem values(1, 'karaoke', 50000, 1,'Kha dung');
insert into DichVuDiKem values(2, 'nước ngọt', 10000, 1,'Kha dung');
insert into DichVuDiKem values(3, 'Khăn mặt', 5000, 1,'Kha dung');
insert into DichVuDiKem values(4, 'matxa', 50000, 1,'Kha dung');

insert into HopDong values(1,'2019:11:05','2019:11:15',300000,20000000,1,1,1);
insert into HopDong values(2,'2019:11:15','2019:11:25',200000,50000000,2,2,2);
insert into HopDong values(3,'2019:11:15','2019:11:25',300000,30000000,1,1,3);
insert into HopDong values(4,'2019:01:01','2019:11:25',300000,10000000,5,1,4);
insert into HopDong values(5,'2019:02:02','2019:11:25',300000,10000000,1,2,5);
insert into HopDong values(6,'2019:09:02','2019:11:25',300000,10000000,4,1,5);
insert into HopDong values(7,'2018:09:02','2019:11:25',300000,10000000,2,5,4);
insert into HopDong values(8,'2018:09:02','2019:11:25',300000,10000000,1,3,3);
insert into HopDong values(9,'2018:09:02','2019:11:25',300000,10000000,3,3,2);
insert into HopDong values(10,'2018:09:02','2019:11:25',300000,10000000,3,2,1);
insert into HopDong values(11,'2017:09:02','2019:11:25',300000,10000000,3,5,1);
insert into HopDong values(12,'2017:09:02','2019:11:25',300000,10000000,3,5,1);
insert into HopDong values(13,'2019:11:05','2019:11:25',300000,10000000,3,4,1);
insert into HopDong values(14,'2019:11:05','2019:11:25',300000,10000000,2,4,2);
insert into HopDong values(15,'2019:11:05','2019:11:25',300000,10000000,4,5,4);
insert into HopDong values(16,'2019:07:05','2019:11:25',300000,10000000,4,5,4);



insert into HopDongChiTiet values(1,1,1);
insert into HopDongChiTiet values(1,2,5);
insert into HopDongChiTiet values(1,3,10);
insert into HopDongChiTiet values(2,1,1);
insert into HopDongChiTiet values(2,2,10);
insert into HopDongChiTiet values(2,3,20);
insert into HopDongChiTiet values(3,1,5);
insert into HopDongChiTiet values(4,1,5);
insert into HopDongChiTiet values(5,1,5);
insert into HopDongChiTiet values(5,2,5);
insert into HopDongChiTiet values(9,2,5);
insert into HopDongChiTiet values(10,3,5);
insert into HopDongChiTiet values(13,1,1);
insert into HopDongChiTiet values(13,2,3);
insert into HopDongChiTiet values(14,2,2);
insert into HopDongChiTiet values(14,3,4);
insert into HopDongChiTiet values(15,3,3);
insert into HopDongChiTiet values(9,4,3);

use furama_resort_tuan_c10g;

 -- task 2
select * from nhanvien
where hoten like '%T%' or hoten like '%H%' or  hoten like '%K%'
having char_length(hoten)<15;

-- task 3
select *, year(CURRENT_DATE)-YEAR(NgaySinh) as So_Tuoi 
from khachhang
where  DiaChi="Đà Nẵng" or DiaChi= "Quảng Trị" 
having So_Tuoi between 18 and 50;
-- having  (EXTRACT(YEAR FROM CURRENT_DATE)-EXTRACT(YEAR FROM NgaySinh)>18) 
-- and (EXTRACT(YEAR FROM CURRENT_DATE)-EXTRACT(YEAR FROM NgaySinh)<50)


-- task 4
select loaikhach.TenLoaiKhach,khachhang.Hoten, count(khachhang.HoTen) as So_Lan_Thue
from loaikhach 
inner join khachhang on khachhang.IDLoaiKhach=loaikhach.IDLoaiKhach
inner join hopdong on hopdong.IDKhachHang=khachhang.IDKhachHang 
where loaikhach.TenLoaiKhach='Diamond'
group by khachhang.HoTen
order by So_Lan_Thue asc;

-- task 5
select khachhang.IDKhachHang,khachhang.hoten,
loaikhach.tenloaikhach,
hopdong.idhopdong,
dichvu.TenDichVu,
hopdong.NgayLamHopDong, hopdong.NgayKetThuc,
dichvudikem.TenDichVuDiKem,
sum(dichvu.ChiPhiThue+(DichVuDiKem.Gia*hopdongchitiet.SoLuong)) as TongTien
from hopdong 
right join dichvu on dichvu.IDDichVu=hopdong.IDDichVu
right join hopdongchitiet on hopdongchitiet.idhopdong=hopdong.idhopdong
right join dichvudikem on dichvudikem.IDDichVuDiKem=hopdongchitiet.IDDichVuDiKem
right join khachhang on khachhang.IDKhachHang=hopdong.IDKhachHang
right join loaikhach on loaikhach.IDLoaiKhach=khachhang.IDLoaiKhach
group by hopdong.idhopdong
order by khachhang.IDKhachHang;

-- task 6 

select DISTINCTROW dichvu.IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu
from dichvu
inner join loaidichvu
on loaidichvu.IDLoaiDichVu=dichvu.IDLoaiDichVu
left join hopdong
on hopdong.IDDichVu=dichvu.IDDichVu
where dichvu.IDDichVu 
not in (select distinct IDDichVu from hopdong where year(ngaylamhopdong)=2019 and quarter(ngaylamhopdong)=1)
group by dichvu.IDDichVu;

-- task 7
select distinct dichvu.IDDichVu,TenDichVu,TenDichVu,DienTich,SoNguoiToiDa,ChiPhiThue,TenLoaiDichVu
from hopdong
right join dichvu on dichvu.IDDichVu=hopdong.IDDichVu
inner join loaidichvu on loaidichvu.IDLoaiDichVu=dichvu.IDLoaiDichVu
where hopdong.IDDichVu in (select distinct IDDichVu 
							from hopdong 
							where year(ngaylamhopdong)=2018
                            )
and hopdong.IDDichVu not in(select distinct IDDichVu 
							from hopdong 
							where year(ngaylamhopdong)=2019
							) 
group by IDDichVu;

select distinct dichvu.IDDichVu,TenDichVu,TenDichVu,DienTich,SoNguoiToiDa,ChiPhiThue,TenLoaiDichVu
from hopdong
inner join dichvu on dichvu.IDDichVu=hopdong.IDDichVu
inner join loaidichvu on loaidichvu.IDLoaiDichVu=dichvu.IDLoaiDichVu
where year(ngaylamhopdong)=2018
and hopdong.IDDichVu not in(select distinct IDDichVu 
							from hopdong 
							where year(ngaylamhopdong)=2019
							) 
group by IDDichVu;
-- task 8
select distinct HoTen as HoTenKhachHang 
from khachhang;

select HoTen as HoTenKhachHang 
from khachhang
group by HoTen;

select  HoTen as HoTenKhachHang 
from khachhang 
union
select  HoTen as HoTenKhachHang 
from khachhang 
;
-- task 9  
select temp.month,count(month(hopdong.ngaylamhopdong)) as so_khach_hang_dang_ky,sum(hopdong.tongtien) as tong_tien
from
(select 1 as month
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as temp
left join hopdong
on month(hopdong.ngaylamhopdong)=temp.month
left join khachhang
on khachhang.idkhachhang=hopdong.idkhachhang
where year(hopdong.ngaylamhopdong)=2019 or month(hopdong.ngaylamhopdong) is null
group by temp.month
order by temp.month asc;

-- task 10
select hopdong.IDHopDong,NgayLamHopDong,NgayKetthuc,TienDatCoc,count(hopdongchitiet.IDHopDong) as SoLuongDichVuDiKem
from hopdong
left join hopdongchitiet
on hopdong.IDHopDong=hopdongchitiet.IDHopDong
group by hopdong.IDHopDong;

-- task 11
select dichvudikem.TenDichVuDiKem,dichvudikem.Gia,dichvudikem.TrangThaiKhaDung,dichvudikem.DonVi 
from
(select khachhang.IDKhachHang,HoTen,DiaChi,TenLoaiKhach from khachhang
inner join loaikhach
on loaikhach.IDLoaiKhach=khachhang.IDLoaiKhach
where TenLoaiKhach='Diamond' and DiaChi in('Vinh','Quảng Ngãi'))as temp
inner join hopdong
on temp.IDKhachHang=hopdong.IDKhachHang
inner join hopdongchitiet
on hopdongchitiet.IDHopDong=hopdong.IDHopDong
inner join dichvudikem
on dichvudikem.IDDichVuDiKem=hopdongchitiet.IDDichVuDiKem;

-- task 12
select temp.IDDichVu, temp.TenDichVu, hopdong.IDHopDong, hopdong.NgayLamHopDong,
nhanvien.HoTen as Nhan_Vien, khachhang.HoTen as Khach_hang, khachhang.SDT,
hopdong.TienDatCoc,count(idDichVuDiKem) as SoLuongDichVuDikem
from (select dichvu.IDDichVu,dichvu.TenDichVu,hopdong.IDHopDong,NgayLamHopDong from dichvu
inner join hopdong
on hopdong.IDDichVu=dichvu.IDDichVu
where dichvu.IDDichVu not in (select IDDichVu from hopdong
								where quarter(NgayLamHopDong) in(1,2) and year(ngaylamhopdong)=2019
								group by IDDichVu)
and year(NgayLamHopDong)=2019 and quarter(NgayLamHopDong)=4) as temp
inner join hopdong
on temp.idhopdong=hopdong.idhopdong
inner join khachhang
on hopdong.IDKhachHang=khachhang.IDKhachHang
inner join nhanvien
on hopdong.IDNhanVien=nhanvien.IDNhanVien
left join hopdongchitiet
on hopdongchitiet.IDHopDong=temp.IDHopDong
group by temp.idhopdong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create temporary table Thong_Ke_Dich_Vu_Di_Kem
select dichvudikem.TenDichVuDiKem,dichvudikem.Gia,dichvudikem.DonVi, count(TenDichVuDiKem) as SoLanSuDung
from hopdongchitiet
inner join dichvudikem
on hopdongchitiet.IDDichVuDiKem=dichvudikem.IDDichVuDiKem
group by dichvudikem.IDDichVuDiKem;

create temporary table max_SoLanSudung
select max(Thong_Ke_Dich_Vu_Di_Kem.SoLanSuDung) as Max_SoLanSuDung
from Thong_Ke_Dich_Vu_Di_Kem;

select TenDichVuDiKem,Gia,DonVi,SoLanSuDung
from max_SoLanSudung
inner join Thong_Ke_Dich_Vu_Di_Kem
on max_SoLanSudung.Max_SoLanSuDung=Thong_Ke_Dich_Vu_Di_Kem.SoLanSuDung;
drop temporary table Thong_Ke_Dich_Vu_Di_Kem;
drop temporary table max_SoLanSudung;

-- task 14 
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select hopdong.IDHopDong, dichvu.TenDichVu, dichvudikem.TenDichVuDiKem, count(TenDichVuDiKem) as SoLanSuDung
from hopdongchitiet
inner join hopdong
on hopdong.IDHopDong=hopdongchitiet.IDHopDong
inner join dichvu
on dichvu.IDDichVu= hopdong.IDDichVu
inner join dichvudikem
on hopdongchitiet.IDDichVuDiKem=dichvudikem.IDDichVuDiKem
group by TenDichVuDiKem
having SoLanSuDung=1
