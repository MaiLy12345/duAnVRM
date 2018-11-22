package com.hellokoding.auth.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hellokoding.auth.model.Product;


//khai lop tuong tac vơi csdl trong spring boot cho lop product
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	//phuong thuc tim kiem theo gia va dien tich
	@Query("select p from Product p where  p.giatri > :giatri AND p.dientich > :dientich")			
	List<Product> finByGiaAndDienTich(@Param("giatri") Long giatri, @Param("dientich") Long dientich);
		
	// phuong thuc tim kiem theo gia, dien tich va huong 
	@Query("select p from Product p where p.giatri > :giatri AND p.dientich > :dientich AND p.huong = :huong")
	List<Product> finByGiaAndDienTichAndHuong(@Param("giatri") Long giatri, @Param("dientich") Long dientich, @Param("huong") String huong );
	
	// phuong tim kiem theo gia, dien tich, huong va thanh pho 
	@Query("select p from Product p where p.giatri > :giatri AND p.dientich > :dientich AND p.thanhpho = :thanhpho AND p.huong = :huong")
	List<Product> finByGiaAndDienTichAndThanhPhoAndHuong(@Param("giatri") Long giatri, @Param("dientich") Long dientich, @Param("thanhpho") String thanhpho,@Param("huong") String huong );
	
	// phuong thuc tim kiem theo gia, dien tich, thanh pho
	@Query("select p from Product p where p.giatri > :giatri AND p.dientich > :dientich AND p.thanhpho = :thanhpho ")
	List<Product> finByGiaAndDienTichAndThanhPho(@Param("giatri") Long giatri, @Param("dientich") Long dientich, @Param("thanhpho") String thanhpho );
		
	//phuong thuc tim kiem theo gia, dien tich, thanh pho, huyen
	@Query("select p from Product p where p.giatri > :giatri AND p.dientich > :dientich AND p.thanhpho = :thanhpho AND p.quanhuyen = :quanhuyen ")
	List<Product> finByGiaAndDienTichAndThanhPhoAndHuyen(@Param("giatri") Long giatri, @Param("dientich") Long dientich, @Param("thanhpho") String thanhpho,@Param("quanhuyen") String quanhuyen );
		
	
	// phuong thuc tim kiem tinh thanh pho, huyen xa, huong va dien tich va gia
	@Query("select p from Product p where p.giatri > :giatri AND p.dientich > :dientich AND p.thanhpho = :thanhpho AND p.quanhuyen = :quanhuyen AND p.huong = :huong")
	List<Product> finByGiaAndDienTichAndThanhPhoAndHuyenAndHuong(@Param("giatri") Long giatri, @Param("dientich") Long dientich,
			@Param("thanhpho") String thanhpho,@Param("quanhuyen") String quanhuyen ,@Param("huong") String huong );
	
	}
