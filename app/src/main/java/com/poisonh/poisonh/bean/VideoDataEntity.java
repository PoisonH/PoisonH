package com.poisonh.poisonh.bean;

import java.util.List;

/**
 * 视频
 * Created by PoisonH on 2016/4/6.
 */
public class VideoDataEntity
{
    private List<ListEntity> list;

    public List<ListEntity> getList()
    {
        return list;
    }

    public void setList(List<ListEntity> list)
    {
        this.list = list;
    }

    public static class ListEntity
    {
        //标题
        private String text;
        //点赞
        private String up;
        //点赞反义词
        private int down;
        //转发
        private String forward;
        //出版时间
        private String passtime;

        private VideoEntity video;
        //视频id
        private String id;

        public String getText()
        {
            return text;
        }

        public void setText(String text)
        {
            this.text = text;
        }

        public String getUp()
        {
            return up;
        }

        public void setUp(String up)
        {
            this.up = up;
        }

        public int getDown()
        {
            return down;
        }

        public void setDown(int down)
        {
            this.down = down;
        }

        public String getForward()
        {
            return forward;
        }

        public void setForward(String forward)
        {
            this.forward = forward;
        }

        public String getPasstime()
        {
            return passtime;
        }

        public void setPasstime(String passtime)
        {
            this.passtime = passtime;
        }

        public VideoEntity getVideo()
        {
            return video;
        }

        public void setVideo(VideoEntity video)
        {
            this.video = video;
        }

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public static class VideoEntity
        {
            private int height;
            private int width;
            //时长
            private int duration;
            private List<String> video;
            private List<String> thumbnail;
            private List<String> download;

            public int getHeight()
            {
                return height;
            }

            public void setHeight(int height)
            {
                this.height = height;
            }

            public int getWidth()
            {
                return width;
            }

            public void setWidth(int width)
            {
                this.width = width;
            }

            public int getDuration()
            {
                return duration;
            }

            public void setDuration(int duration)
            {
                this.duration = duration;
            }


            public List<String> getVideo()
            {
                return video;
            }

            public void setVideo(List<String> video)
            {
                this.video = video;
            }

            public List<String> getThumbnail()
            {
                return thumbnail;
            }

            public void setThumbnail(List<String> thumbnail)
            {
                this.thumbnail = thumbnail;
            }

            public List<String> getDownload()
            {
                return download;
            }

            public void setDownload(List<String> download)
            {
                this.download = download;
            }
        }
    }
}
