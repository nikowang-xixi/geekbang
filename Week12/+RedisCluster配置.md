{\rtf1\ansi\ansicpg936\cocoartf2580
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 HelveticaNeue-Bold;\f1\fnil\fcharset134 PingFangSC-Semibold;\f2\fnil\fcharset0 HelveticaNeue;
\f3\fnil\fcharset134 PingFangSC-Regular;\f4\fnil\fcharset0 .AppleSystemUIFontMonospaced-Regular;}
{\colortbl;\red255\green255\blue255;\red189\green198\blue208;\red12\green14\blue18;\red36\green41\blue46;
\red72\green146\blue255;\red120\green129\blue140;\red18\green21\blue26;\red104\green177\blue255;\red252\green99\blue95;
}
{\*\expandedcolortbl;;\cssrgb\c78824\c81961\c85098;\cssrgb\c5098\c6667\c9020;\cssrgb\c18824\c21176\c23922;
\cssrgb\c34510\c65098\c100000;\cssrgb\c54510\c58039\c61961;\cssrgb\c8627\c10588\c13333;\cssrgb\c47451\c75294\c100000;\cssrgb\c100000\c48235\c44706;
}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\b\fs64 \cf2 \cb3 \expnd0\expndtw0\kerning0
Redis Cluster 
\f1 \'c5\'e4\'d6\'c3
\f0 \cb1 \
\pard\pardeftab720\partightenfactor0

\f2\b0\fs32 \cf2 \cb4 \
\pard\pardeftab720\partightenfactor0

\f0\b\fs48 \cf5 \cb1 \
\pard\pardeftab720\partightenfactor0

\f1 \cf2 \cb3 \'bc\'f2\'bd\'e9
\f0 \cb1 \
\pard\pardeftab720\partightenfactor0

\f2\b0\fs32 \cf2 \cb3 \uc0\u8194 \u8194 \u8194 \u8194 
\f3 \'d4\'da
\f2  Centos8 
\f3 \'c9\'cf\'b2\'bf\'ca\'f0
\f2  redis Cluster\cb1 \

\f3 \cb3 \'d5\'e2\'c0\'ef\'be\'cd\'d0\'b4\'d2\'bb\'b8\'f6\'b4\'f3\'b8\'c5\'a3\'ac\'b1\'c8\'bd\'cf\'ba\'c3\'b5\'c4\'a3\'ac\'bf\'c9\'d2\'d4\'b2\'ce\'bf\'bc\'ba\'f3\'c3\'e6\'b5\'c4\'c1\'b4\'bd\'d3\'a3\'ac\'bd\'f8\'d0\'d0\'b8\'fc\'cf\'ea\'cf\'b8\'a3\'ac\'cd\'ea\'d5\'fb\'b5\'c4\'c9\'e8\'d6\'c3
\f2 \cb1 \
\pard\pardeftab720\partightenfactor0

\f0\b\fs40 \cf5 \
\pard\pardeftab720\partightenfactor0

\f1 \cf2 \cb3 \'c5\'e4\'d6\'c3\'cf\'ea\'c7\'e9\'d3\'eb\'bc\'c7\'c2\'bc
\f0 \cb1 \
\pard\pardeftab720\partightenfactor0

\f4\b0\fs27\fsmilli13600 \cf6 \cb7 # 
\f3 \'b0\'b2\'d7\'b0
\f4 \cf2 \
dnf module install redis -y\
\
\cf6 # 
\f3 \'d0\'de\'b8\'c4\'c5\'e4\'d6\'c3\'ce\'c4\'bc\'fe
\f4 \cf2 \
cp /etc/redis.conf /etc/redis.conf.orig\
vi /etc/redis.conf\
\
\cf6 # 
\f3 \'d0\'de\'b8\'c4\'c4\'da\'c8\'dd\'c8\'e7\'cf\'c2
\f4 \cf2 \
\pard\pardeftab720\partightenfactor0
\cf8 bind\cf2   10.42.0.247\
protected-mode no\
port 6379\
cluster-enabled yes\
cluster-config-file nodes-6379.conf\
cluster-node-timeout 15000\
\
\pard\pardeftab720\partightenfactor0
\cf6 # 
\f3 \'c6\'f4\'b6\'af
\f4 \cf2 \
systemctl restart redis\
cat /var/log/redis/redis.log\
\
\cf6 # 
\f3 \'cf\'c2\'c3\'e6\'b5\'c4
\f4 6380,6381,6382,6383,6384
\f3 \'b0\'b4\'d5\'d5\'c9\'cf\'c3\'e6\'c5\'e4\'d6\'c3\'ba\'c3\'d2\'d4\'ba\'f3\'a3\'ac\'bd\'f8\'d0\'d0\'cf\'c2\'c3\'e6\'c3\'fc\'c1\'ee
\f4 \cf2 \
redis-cli --cluster create 192.168.101.105:6379 192.168.101.105:6380 192.168.101.105:6381 192.168.101.105:6382 192.168.101.105:6383 192.168.101.105:6384 --cluster-replicas\
redis-cli -h 192.168.101.105 -p 6379 cluster nodes\
redis-cli -h 192.168.101.105 -p 6379 cluster nodes  \cf9 |\cf2  grep master\
redis-cli -h 192.168.101.105 -p 6379 cluster nodes  \cf9 |\cf2  grep slave}