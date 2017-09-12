package be.beniben.cruciblereport.repository;

import be.beniben.cruciblereport.model.CruReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
@Transactional(readOnly = true)
public interface CruReviewRepository extends JpaRepository<CruReview,Long>{

    List<CruReview> findAllBycruCreateDateBetween(LocalDateTime start,LocalDateTime end);

    @Query(value="select utilisateur.CRU_USER_NAME,count(utilisateur.CRU_USER_NAME) as nbreview from cru_review review" +
            ",cru_review_participant participant,cru_user utilisateur" +
           " where" +
           " TO_CHAR((TO_DATE('1970-01-01','YYYY-MM-DD') + review.cru_create_date / 86400000),'YYYY-MM') = ?1" +
           " and " +
           " review.cru_review_id= participant.cru_review_id" +
           " and participant.CRU_REVIEWER = 1" +
           " and participant.cru_time_spent is not null" +
           " and  participant.cru_user = utilisateur.cru_user_id group by utilisateur.CRU_USER_NAME order by nbreview desc",nativeQuery = true)
    List<Object[]> findNbReviewsByUserOnAMonth(@Param("1") String mois);

    @Query(value="select utilisateur.CRU_USER_NAME,count(utilisateur.CRU_USER_NAME) as nb_comments from fecru.cru_review review,fecru.cru_review_participant participant,fecru.cru_user utilisateur, fecru.cru_comment com"+
            " where TO_CHAR((TO_DATE('1970-01-01','YYYY-MM-DD') + review.cru_create_date / 86400000),'YYYY-MM')=?1"+
            " and review.cru_review_id= participant.cru_review_id "+
            " and com.cru_user_id = utilisateur.cru_user_id"+
            " and participant.CRU_REVIEWER = 1"+
            " and com.CRU_REVIEW_ID =  review.cru_review_id"+
            " and participant.cru_time_spent is not null" +
            " and  participant.cru_user = utilisateur.cru_user_id group by utilisateur.CRU_USER_NAME order by nb_comments desc",nativeQuery = true)
    List<Object[]> findNbCommentsByUserByReviewOnAMonth(@Param("1") String mois);

    @Query(value="select utilisateur.CRU_USER_NAME,count(utilisateur.CRU_USER_NAME) as nb_comments  from fecru.cru_review review,fecru.cru_review_participant participant,fecru.cru_user utilisateur, fecru.cru_comment com" +
            " where TO_CHAR((TO_DATE('1970-01-01','YYYY-MM-DD') + review.cru_create_date / 86400000),'YYYY-MM')=?1" +
            " and review.cru_review_id= participant.cru_review_id" +
            " and com.cru_user_id = utilisateur.cru_user_id" +
            " and participant.CRU_REVIEWER = 1" +
            " and com.CRU_REVIEW_ID =  review.cru_review_id" +
            " and com.CRU_DEFECT_RAISED=1" +
            " and participant.cru_time_spent is not null" +
            " and  participant.cru_user = utilisateur.cru_user_id group by utilisateur.CRU_USER_NAME order by nb_comments desc",nativeQuery = true)
    List<Object[]> findDetectedDefectsByReviewerOnAMonth(@Param("1") String mois);

    @Query(value="select Auteur, id_review,Statut,Ticket, utilisateur.CRU_USER_NAME as reviewer, nb_comments,Temps from" +
            " (select review.CRU_REVIEW_ID as id_review1, utilisateur.CRU_USER_NAME as Auteur, review.cru_name as Ticket, review.cru_state as Statut, participant.CRU_USER as reviewer,  " +
            " TO_CHAR(round(participant.cru_time_spent /1000 / 60) ||'m' ) as Temps from fecru.cru_review review, fecru.cru_user utilisateur, fecru.cru_review_participant participant" +
            " where TO_CHAR((TO_DATE('1970-01-01','YYYY-MM-DD') + review.cru_create_date / 86400000),'YYYY-MM') in (?1)" +
            " and  review.CRU_CREATOR = utilisateur.cru_user_id" +
            " and participant.CRU_REVIEWER = 1" +
            " and participant.cru_time_spent is not null" +
            " and review.cru_review_id= participant.cru_review_id)," +
            " (SELECT review.CRU_REVIEW_ID as id_review, part.cru_USER as commenter, count(com1.CRU_COMMENT_ID) as  nb_comments" +
            " FROM fecru.cru_review review join fecru.CRU_REVIEW_PARTICIPANT part " +
            "  on review.CRU_REVIEW_ID = part.CRU_REVIEW_ID" +
            "  LEFT JOIN fecru.cru_comment com1 ON  com1.cru_user_id = part.CRU_USER and com1.cru_review_id = part.cru_review_id" +
            "  WHERE TO_CHAR((TO_DATE('1970-01-01','YYYY-MM-DD') + review.cru_create_date / 86400000),'YYYY-MM')=?1" +
            "  AnD part.CRU_REVIEWER = 1" +
            " GROUP BY review.CRU_REVIEW_ID,part.cru_USER), fecru.cru_user utilisateur" +
            " WHERE reviewer=utilisateur.CRU_USER_ID" +
            " and commenter = utilisateur.CRU_USER_ID" +
            " and id_review=id_review1" +
            " order by Auteur,id_review, Ticket",nativeQuery = true)
    List<Object[]> findReviewByTicket(@Param("1") String mois);

    @Query(value ="select utilisateur.CRU_USER_NAME,NVL(round((Sum(participant.CRU_TIME_SPENT)/1000 / 60)),0) as totalTime from CRU_REVIEW review,CRU_REVIEW_PARTICIPANT participant,cru_user utilisateur where" +
            " TO_CHAR((TO_DATE('1970-01-01','YYYY-MM-DD') + review.cru_create_date / 86400000),'YYYY-MM')=?1"+
            " and  review.cru_review_id= participant.cru_review_id " +
            " and  participant.cru_user = utilisateur.cru_user_id  " +
            " and participant.CRU_REVIEWER = 1 group by utilisateur.CRU_USER_NAME order by totalTime desc ",nativeQuery = true)
    List<Object[]> getTotalTimePassedByMonthByReviewer(String mois);
}
