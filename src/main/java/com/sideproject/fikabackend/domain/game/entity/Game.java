package com.sideproject.fikabackend.domain.game.entity;

import com.sideproject.fikabackend.domain.game.dto.GameDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Entity
public class Game {

    /**게임 PK**/
    @Id
    private Long gmId;

    /**게임 구분(국내/해외)**/
    @NotNull(message = "FootballType must not be null")
    private String gmTp;

    /**게임 리그**/
    @NotNull(message = "Football-League must not be null")
    private String gmLeague;

    /**홈팀**/
    @NotNull(message = "Football-Home must not be null")
    private String gmHome;

    /**홈팀 스코어**/
    private String gmHomeScr;

    /**홈팀 앰뷸럼 이미지**/
    @NotNull(message = "Football-Home must not be null")
    private String gmHomeImg;

    /**어웨이팀**/
    @NotNull(message = "Football-Away must not be null")
    private String gmAway;

    /**어웨이팀 스코어**/
    private String gmAwayScr;

    /**어웨이팀 앰뷸럼 이미지**/
    @NotNull(message = "Football-Away must not be null")
    private String gmAwayImg;

    /**경기 일자**/
    @NotNull(message = "Football-Date must not be null")
    private String gmDate;

    /**경기 시간**/
    @NotNull(message = "Football-Time must not be null")
    private String gmTime;

    public Game(GameDto gameDto) {
        this.gmId = gameDto.getGmId();
        this.gmTp = gameDto.getGmTp();
        this.gmLeague = gameDto.getGmLeague();
        this.gmHome = gameDto.getGmHome();
        this.gmHomeImg = gameDto.getGmHomeImg();
        this.gmAway = gameDto.getGmAway();
        this.gmAwayImg = gameDto.getGmAwayImg();
        this.gmDate = gameDto.getGmDate();
        this.gmTime = gameDto.getGmTime();
    }
}
