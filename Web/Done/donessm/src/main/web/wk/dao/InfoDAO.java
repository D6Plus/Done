package wk.dao;

import wk.entity.Info;
import wk.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoDAO {
    void createNewInfo(@Param("userID") String userID, @Param("infoName") String infoName, @Param("infoSelf") String infoSelf);
    int countNewInfo(@Param("userID") String userID,@Param("status") String status);
    List<Info> queryAllInfo(@Param("userID") String userID, @Param("status") String status);
}
