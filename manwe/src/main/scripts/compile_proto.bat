cd ..
set proto_dir=manwe\src\main\proto
set out_dir=manwe\target\generated-sources\proto
mkdir %out_dir%
protoc-3.15.5-win64\bin\protoc.exe -I=%proto_dir% --java_out=%out_dir% record.proto