package ru.skillbranch.data.storage.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import ru.skillbranch.data.network.responses.UserModelRes;

@Entity(active = true, nameInDb = "MEMBERS")
public class Member {

    @Unique
    private String url;

    @Unique
    private String name;

    private String born;

    private String died;

    private String titles;

    private String aliases;

    private String father;

    private String mother;

    private String words;

    public Member(UserModelRes userModelRes, String wordsString) {
        url = userModelRes.getUrl();
        name = userModelRes.getName();
        born = userModelRes.getBorn();
        died = userModelRes.getDied();
        titles = userModelRes.getTitles().toString();
        aliases = userModelRes.getAliases().toString();
        father = userModelRes.getFather();
        mother = userModelRes.getMother();
        words = wordsString;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1742104579)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMemberDao() : null;
    }

    /** Used for active entity operations. */
    @Generated(hash = 1200613910)
    private transient MemberDao myDao;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    public String getWords() {
        return this.words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getMother() {
        return this.mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return this.father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getAliases() {
        return this.aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getTitles() {
        return this.titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getDied() {
        return this.died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getBorn() {
        return this.born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Generated(hash = 1522391737)
    public Member(String url, String name, String born, String died, String titles,
            String aliases, String father, String mother, String words) {
        this.url = url;
        this.name = name;
        this.born = born;
        this.died = died;
        this.titles = titles;
        this.aliases = aliases;
        this.father = father;
        this.mother = mother;
        this.words = words;
    }

    @Generated(hash = 367284327)
    public Member() {

    }
}