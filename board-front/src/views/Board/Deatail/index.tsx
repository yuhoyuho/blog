import React from 'react'
import './style.css';

//      component : 게시물 상세 화면 컴포넌트        //
export default function BoardDetail() {

  //      component : 게시물 상세 상단 컴포넌트        //
  const BoardDetailTop = () => {

  //      render : 게시물 상세 상단 컴포넌트 렌더링        //
    return(
      <div id='board-detail-top'>
        <div className='board-detail-top-header'>
          <div className='board-detail-title'>{'제목입니다 제목제목'}</div>
          <div className='board-detail-top-sub-box'>
            <div className='board-detail-write-info-box'>
              <div className='board-detail-writer-profile-image'></div>
              <div className='board-detail-writer-nickname'>{'유호123'}</div>
              <div className='board-detail-info-divider'>{'\|'}</div>
              <div className='board-detail-write-date'>{'2025.03.04'}</div>
            </div>
            <div className='icon-button'>
              <div className='icon more-icon'></div>
            </div>
            <div className='board-detail-more-box'>
              <div className='board-detail-update-button'>{'수정'}</div>
              <div className='divider'></div>
              <div className='board-detail-delete-button'>{'삭제'}</div>
            </div>
          </div>
        </div>
        <div className='divider'></div>
        <div className='board-detail-top-main'>
          <div className='board-detail-main-text'>{'가나다라마바사아자차카타파하'}</div>
          <div className='board-detail-main-image'></div>
        </div>
      </div>
    )
  }

  //      component : 게시물 상세 하단 컴포넌트        //
  const BoardDetailBottom = () => {

  //      render : 게시물 상세 하단 컴포넌트 렌더링        //
    return(<></>)
  }

  //      render : 게시물 상세 화면 컴포넌트 렌더링        //
  return (
    <div id='board-detail-wrapper'>
      <div className='board-detail-container'>
        <BoardDetailTop />
        <BoardDetailBottom />
      </div>
    </div>
  )
}
