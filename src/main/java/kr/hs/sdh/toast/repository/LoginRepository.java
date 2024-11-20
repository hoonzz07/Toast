package kr.hs.sdh.toast.repository;


import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.entity.CustomerRole;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginRepository {

    @Results(
            id = "customer",
            value = {
            @Result(column = "c_id" , property = "id"),
            @Result(column = "c_password" , property = "password"),
            @Result(column = "c_alias" , property = "alias"),
            @Result(column = "p_uuid" , property = "people" , one = @One(resultMap = PeopleRepository.PEOPLE))
    }) @Select(value = "")
    Customer customer();


    @ResultMap(value = "customer")
    @Select(value = """
    SELECT * FROM customer AS c 
    INNER JOIN  people AS P ON c.p_uuid = p.p_uuid
    WHERE c_id = #{userId}
    """)
    Customer findById (final String userId);
//    @Insert("""
//    INSERT INTO customer (c_id, c_password, c_name, c_identity, c_email, c_contact, c_address)
//    VALUES(#{c_id}, #{c_password}, #{c_name}, #{c_identity}, #{c_email}, #{c_contact}, #{c_address})
//""")
//    void insertCustomer(Customer customer);
}
