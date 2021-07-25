{\rtf1\ansi\ansicpg936\cocoartf2580
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset134 PingFangSC-Semibold;\f1\fnil\fcharset0 HelveticaNeue-Bold;\f2\fnil\fcharset0 HelveticaNeue;
\f3\fnil\fcharset134 PingFangSC-Regular;\f4\fnil\fcharset0 .AppleSystemUIFontMonospaced-Regular;}
{\colortbl;\red255\green255\blue255;\red189\green198\blue208;\red12\green14\blue18;\red72\green146\blue255;
\red18\green21\blue26;\red104\green177\blue255;\red150\green204\blue255;\red252\green99\blue95;\red120\green129\blue140;
}
{\*\expandedcolortbl;;\cssrgb\c78824\c81961\c85098;\cssrgb\c5098\c6667\c9020;\cssrgb\c34510\c65098\c100000;
\cssrgb\c8627\c10588\c13333;\cssrgb\c47451\c75294\c100000;\cssrgb\c64706\c83922\c100000;\cssrgb\c100000\c48235\c44706;\cssrgb\c54510\c58039\c61961;
}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\b\fs48 \cf2 \cb3 \expnd0\expndtw0\kerning0
\'c5\'e4\'d6\'c3\'bc\'c7\'c2\'bc
\f1 \cb1 \
\pard\pardeftab720\partightenfactor0

\fs40 \cf4 \
\pard\pardeftab720\partightenfactor0
\cf2 \cb3 Redis
\f0 \'d6\'f7\'b4\'d3\'b8\'b4\'d6\'c6
\f1 \cb1 \
\pard\pardeftab720\partightenfactor0

\f2\b0\fs32 \cf2 \cb3 \uc0\u8194 \u8194 \u8194 \u8194 
\f3 \'d7\'bc\'b1\'b8\'c5\'e4\'d6\'c3\'ce\'c4\'bc\'fe\'a3\'ac\'b7\'d6\'b1\'f0\'c6\'f4\'b6\'af\'c6\'f4\'b6\'af\'d4\'da
\f2 6380/6381/6382,6380
\f3 \'ce\'aa\'d6\'f7
\f2 \cb1 \
\pard\pardeftab720\partightenfactor0

\f4\fs27\fsmilli13600 \cf2 \cb5 port 6379\
\pard\pardeftab720\partightenfactor0
\cf6 bind\cf2  192.168.11.202\
requirepass \cf7 "myredis"\cf2 \
daemonize yes\
logfile \cf7 "6379.log"\cf2 \
dbfilename \cf7 "dump-6379.rdb"\cf2 \
dir \cf7 "/opt/soft/redis/data"\cf2 \
\pard\pardeftab720\partightenfactor0

\f2\fs32 \cf2 \cb1 \
\pard\pardeftab720\partightenfactor0

\f4\fs27\fsmilli13600 \cf2 \cb5 docker run -dit --name redis1 -p 6381:6379 -p 16381:16381 redis \
docker run -dit --name redis2 -p 6382:6379 -p 16382:16382 redis \
docker run -dit --name redis3 -p 6383:6379 -p 16383:16383 redis \
\
\
docker \cf6 exec\cf2  -ti redis2 redis-cli\
\
127.0.0.1:\cf8 6379>\cf2  REPLICAOF 192.168.101.104 6381\
OK\
\
127.0.0.1:\cf8 6379>\cf2  info replication\
\pard\pardeftab720\partightenfactor0
\cf9 # Replication\cf2 \
role:slave\
master_host:192.168.101.104\
master_port:6381\
master_link_status:up\
master_last_io_seconds_ago:0\
master_sync_in_progress:0\
slave_repl_offset:126\
slave_priority:100\
slave_read_only:1\
connected_slaves:0\
master_replid:3003c01fb5c96132dbc1e366cdc94b214a0ac52d\
master_replid2:0000000000000000000000000000000000000000\
master_repl_offset:126\
second_repl_offset:-1\
repl_backlog_active:1\
repl_backlog_size:1048576\
repl_backlog_first_byte_offset:1\
repl_backlog_histlen:126\
\
\
docker \cf6 exec\cf2  -ti redis3 redis-cli\
\
127.0.0.1:\cf8 6379>\cf2  REPLICAOF 192.168.101.104 6381\
OK\
\
127.0.0.1:\cf8 6379>\cf2  info replication\
\cf9 # Replication\cf2 \
role:slave\
master_host:192.168.101.104\
master_port:6381\
master_link_status:up\
master_last_io_seconds_ago:7\
master_sync_in_progress:0\
slave_repl_offset:98\
slave_priority:100\
slave_read_only:1\
connected_slaves:0\
master_replid:3003c01fb5c96132dbc1e366cdc94b214a0ac52d\
master_replid2:0000000000000000000000000000000000000000\
master_repl_offset:98\
second_repl_offset:-1\
repl_backlog_active:1\
repl_backlog_size:1048576\
repl_backlog_first_byte_offset:71\
repl_backlog_histlen:28\
\
\
docker \cf6 exec\cf2  -ti redis1 redis-cli\
\
127.0.0.1:\cf8 6379>\cf2  info replication\
\cf9 # Replication\cf2 \
role:master\
connected_slaves:2\
slave0:ip=172.17.0.1,port=6379,state=online,offset=140,lag=0\
slave1:ip=172.17.0.1,port=6379,state=online,offset=140,lag=0\
master_replid:3003c01fb5c96132dbc1e366cdc94b214a0ac52d\
master_replid2:0000000000000000000000000000000000000000\
master_repl_offset:140\
second_repl_offset:-1\
repl_backlog_active:1\
repl_backlog_size:1048576\
repl_backlog_first_byte_offset:1\
repl_backlog_histlen:140\
\pard\pardeftab720\partightenfactor0

\f1\b\fs40 \cf4 \cb1 \
\pard\pardeftab720\partightenfactor0

\f0 \cf2 \cb3 \'c5\'e4\'d6\'c3
\f1  Sentinel 
\f0 \'c9\'da\'b1\'f8
\f1 \cb1 \
\pard\pardeftab720\partightenfactor0

\f2\b0\fs32 \cf2 \cb3 \uc0\u8194 \u8194 \u8194 \u8194 sentinel
\f3 \'c5\'e4\'d6\'c3\'ce\'c4\'bc\'fe\'c8\'e7\'cf\'c2\'a3\'ba
\f2 \cb1 \
\pard\pardeftab720\partightenfactor0

\f4\fs27\fsmilli13600 \cf2 \cb5 port 16381\
daemonize no\
pidfile /var/run/redis-sentinel.pid\
logfile \cf7 ""\cf2 \
dir /tmp\
sentinel monitor mymaster 192.168.101.104 6381 2\
sentinel down-after-milliseconds mymaster 10000\
sentinel failover-timeout mymaster 30000\
sentinel parallel-syncs mymaster 1\
\pard\pardeftab720\partightenfactor0

\f2\fs32 \cf2 \cb3 \uc0\u8194 \u8194 \u8194 \u8194 
\f3 \'c3\'fc\'c1\'ee\'d4\'cb\'d0\'d0\'bc\'c7\'c2\'bc\'c8\'e7\'cf\'c2\'a3\'ba
\f2 \cb1 \
\pard\pardeftab720\partightenfactor0

\f4\fs27\fsmilli13600 \cf2 \cb5 docker cp sentinel.conf redis1:/etc/sentinel.conf\
\
docker \cf6 exec\cf2  -ti redis1 redis-sentinel /etc/sentinel.conf\
\
44:X 03 Jan 2021 06:39:16.506 \cf9 # +monitor master mymaster 192.168.101.104 6381 quorum 2\cf2 \
44:X 03 Jan 2021 06:39:16.512 \cf8 *\cf2  +slave slave 172.17.0.1:6379 172.17.0.1 6379 @ mymaster 192.168.101.104 6381\
44:X 03 Jan 2021 06:39:26.666 \cf8 *\cf2  +convert-to-slave slave 172.17.0.1:6379 172.17.0.1 6379 @ mymaster 192.168.101.104 6381}