//
//  homeTableViewCell.m
//  Beplused
//
//  Created by CS_Mac4 on 06/08/14.
//  Copyright (c) 2014 CS_Mac4. All rights reserved.
//

#import "PostCommentTableViewCell.h"

@implementation PostCommentTableViewCell

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier
{
    self = [super initWithStyle:style reuseIdentifier:reuseIdentifier];
    if (self) {
        // Initialization code
        [self addControl];
    }
    return self;
}

-(void)addControl
{
    
    
    @try {
        
   
    
    UIImageView *baseImgView
        
        =[[UIImageView alloc] initWithFrame:CGRectMake(0, 0, self.frame.size.width, self.frame.size.height)];
    [baseImgView setUserInteractionEnabled:TRUE];
   // baseImgView.image=[UIImage imageNamed:@"base.png"];
    [self addSubview:baseImgView];

       
    

     _lblPost=[[UILabel alloc]initWithFrame:CGRectZero];
    [_lblPost setNumberOfLines:0];
        
        //[_lblPost setBackgroundColor:[UIColor greenColor]];
        [_lblPost setTextAlignment:NSTextAlignmentLeft];
        [_lblPost setFont:[UIFont systemFontOfSize:14.0f]];
        [_lblPost setNumberOfLines:0];
        [_lblPost setLineBreakMode:NSLineBreakByWordWrapping];
    [baseImgView addSubview:_lblPost];
      //  NSLog(@"%f",self.frame.size.width);
    if([[UIScreen mainScreen] bounds].size.width==320)
    {
       _asyncPostImageView = [[UIImageView alloc] initWithFrame: CGRectMake(11,110,self.frame.size.width-75,120)];
    }
    else{
      _asyncPostImageView = [[UIImageView alloc] initWithFrame: CGRectMake(11,110,self.frame.size.width-22,120)];
    }
   
    _asyncPostImageView.clipsToBounds=YES;
        [_asyncPostImageView setUserInteractionEnabled:TRUE];
    _asyncPostImageView.backgroundColor=[UIColor clearColor];
    [baseImgView addSubview:_asyncPostImageView];
        
         _mySpinner2 = [[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleGray];
        _mySpinner2.center = CGPointMake(_asyncPostImageView.frame.size.width/2, _asyncPostImageView.frame.size.height/2);
        
        [_asyncPostImageView addSubview:_mySpinner2];

    
    
    
    _EditButton=[UIButton buttonWithType:UIButtonTypeCustom];
    _EditButton.frame=CGRectMake(280, 10, 30, 30);
   // _EditButton.backgroundColor=[UIColor redColor];
    [_EditButton setBackgroundImage:[UIImage imageNamed:@"more_optipon_btn.png"] forState:UIControlStateNormal];
   // [baseImgView addSubview:_EditButton];
    
    
    
    
    


    
    _nameLabel = [[UILabel alloc] initWithFrame:CGRectMake(65, 10, 200, 20)];
    _nameLabel.backgroundColor = [UIColor clearColor];
        _nameLabel.font=[UIFont boldSystemFontOfSize:14.0f];
    _nameLabel.textColor=[UIColor blackColor];
    _nameLabel.numberOfLines=0;
    [baseImgView addSubview:_nameLabel];
    
    
        
        _lbldate= [[UILabel alloc] initWithFrame:CGRectMake(60,30,225,20)];
        _lbldate.backgroundColor = [UIColor clearColor];
        _lbldate.font=[UIFont systemFontOfSize:11];
        _lbldate.textColor=[UIColor lightGrayColor];
        _lbldate.numberOfLines=0;
        [baseImgView addSubview:_lbldate];
    
  
    
    
    _asyncProfileImageView = [[UIImageView alloc] initWithFrame: CGRectMake(11,6,45,45)];
    
    [_asyncProfileImageView setBackgroundColor:[UIColor lightGrayColor]];
    
    _asyncProfileImageView.clipsToBounds = YES;
    _asyncProfileImageView.layer.cornerRadius = _asyncProfileImageView.frame.size.width/2;
        
        [_asyncProfileImageView.layer setBorderWidth:2.0f];
        [_asyncProfileImageView.layer setBorderColor:[[UIColor colorWithRed:87.0f/255.0f green:187.0f/255.0f blue:157.0f/255.0f alpha:1.0f] CGColor]];
        
        
    [baseImgView addSubview:_asyncProfileImageView];
        
        _mySpinner = [[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleGray];
        _mySpinner.center = CGPointMake(_asyncProfileImageView.frame.size.width/2, _asyncProfileImageView.frame.size.height/2);
        
        [_asyncProfileImageView addSubview:_mySpinner];

    
   
    
    
    
    

    
   
    
    
//    _noOfLikes=[[UILabel alloc] initWithFrame:CGRectZero];
//    _noOfLikes.textColor=[UIColor lightGrayColor];
//        [_noOfLikes setText:@"5"];
//        [_noOfLikes setTextAlignment:NSTextAlignmentRight];
//         _noOfLikes.font=[UIFont systemFontOfSize:15];
//     [baseImgView addSubview:_noOfLikes];
    
    
    
  
          
    
    
    
//    _noOfComments=[[UILabel alloc] initWithFrame:CGRectZero];
//    _noOfComments.textColor=[UIColor lightGrayColor];
//        [_noOfComments setTextAlignment:NSTextAlignmentRight];
//        [_noOfComments setText:@"3456"];
//     _noOfComments.font=[UIFont systemFontOfSize:12];
//    [baseImgView addSubview:_noOfComments];
    
    
   
    
    
      
    
    
    _commentButton=[UIButton buttonWithType:UIButtonTypeCustom];
    _commentButton.frame=CGRectZero;
    _commentButton.backgroundColor=[UIColor clearColor];
    [_commentButton setBackgroundImage:[UIImage imageNamed:@"comment.png"] forState:UIControlStateNormal];
    [self addSubview:_commentButton];
    
    }
    @catch (NSException *exception) {
        
    }
   
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated
{
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

@end
