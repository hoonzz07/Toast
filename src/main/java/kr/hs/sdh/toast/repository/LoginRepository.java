package kr.hs.sdh.toast.repository;


import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.entity.CustomerRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginRepository {

    @Select("SELECT * FROM customer where c_id = #{c_id}")
    Customer getCustomerRoleByCId(String c_id);

    @Insert("""
    INSERT INTO customer (c_id, c_password, c_name, c_identity, c_email, c_contact, c_address) 
    VALUES(#{c_id}, #{c_password}, #{c_name}, #{c_identity}, #{c_email}, #{c_contact}, #{c_address})
""")
    void insertCustomer(Customer customer);
}
