package kr.hs.sdh.toast.repository;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BankCustomerRepository {

//    @Select(value = """
//        SELECT * from bank_customer As bc inner join bank_customer_bridge AS bcb
//        ON bc.bc_uuid = bcb.bc_uuid
//        where bcb.b_uuid = #{b_uuid }
//""")
//    List<BankCustomer> findAllByBankId(final String b_uuid);
//
//    @Results({
//     @Result(column = "bc_uuid" , property = "bankAccount" , many = @Many(select = "kr.hs.sdh.toast.repository.BankAccountRepository.findAllByCustomerId"))
//    })
//    @Select(value= "SELECT * FROM bank_customer WHERE bc_identity = #{identity}")
//    BankCustomer findByIdentity(final String identity);
}
